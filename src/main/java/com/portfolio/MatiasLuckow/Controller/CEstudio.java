package com.portfolio.MatiasLuckow.Controller;

import com.portfolio.MatiasLuckow.Dto.dtoEstudio;
import com.portfolio.MatiasLuckow.Entity.Estudio;
import com.portfolio.MatiasLuckow.Security.Controller.Mensaje;
import com.portfolio.MatiasLuckow.Service.SEstudio;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("estudio")  //localhost:8080/estudio
@CrossOrigin(origins = "https://portfoliofrontend-37881.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CEstudio {
    
    @Autowired
    SEstudio sEstudio;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Estudio>> list(){
        List<Estudio> list = sEstudio.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Estudio> getById(@PathVariable("id")int id){
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Estudio educacion = sEstudio.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sEstudio.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEstudio dtoeducacion){
        if(StringUtils.isBlank(dtoeducacion.getInstitucion())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sEstudio.existsByNombreE(dtoeducacion.getInstitucion())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Estudio educacion = new Estudio(
                dtoeducacion.getInstitucion(), dtoeducacion.getTitulo(), dtoeducacion.getFechaFin(), 
                dtoeducacion.getFechaFin(), dtoeducacion.getImagen());
        sEstudio.save(educacion);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEstudio dtoeducacion){
        if(!sEstudio.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sEstudio.existsByNombreE(dtoeducacion.getInstitucion()) && sEstudio.getByNmbreE(dtoeducacion.getInstitucion()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtoeducacion.getInstitucion())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Estudio educacion = sEstudio.getOne(id).get();
        
        educacion.setInstitucion(dtoeducacion.getInstitucion());
        educacion.setTitulo(dtoeducacion.getTitulo());
        educacion.setFechaInicio(dtoeducacion.getFechaInicio());
        educacion.setFechaFin(dtoeducacion.getFechaFin());
        educacion.setImagen(dtoeducacion.getImagen());
        
        sEstudio.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }

}
