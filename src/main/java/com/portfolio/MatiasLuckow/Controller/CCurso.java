package com.portfolio.MatiasLuckow.Controller;

import com.portfolio.MatiasLuckow.Dto.dtoCurso;
import com.portfolio.MatiasLuckow.Entity.Curso;
import com.portfolio.MatiasLuckow.Security.Controller.Mensaje;
import com.portfolio.MatiasLuckow.Service.SCurso;
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
@RequestMapping("curso")  //localhost:8080/curso
@CrossOrigin(origins = "http://localhost:4200")
public class CCurso {

@Autowired
    SCurso sCurso;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> list(){
        List<Curso> list = sCurso.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @GetMapping("/detail/{id}")
    public ResponseEntity<Curso> getById(@PathVariable("id")int id){
        if(!sCurso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.BAD_REQUEST);
        }
        
        Curso curso = sCurso.getOne(id).get();
        return new ResponseEntity(curso, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sCurso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sCurso.delete(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoCurso dtocurso){
        if(StringUtils.isBlank(dtocurso.getNombreCurso())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if(sCurso.existsByNombreCurso(dtocurso.getNombreCurso())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        
        Curso curso = new Curso(
                dtocurso.getNombreCurso(), dtocurso.getTitulo(), dtocurso.getFechaInicio(), dtocurso.getFechaFin()
            );
        sCurso.save(curso);
        return new ResponseEntity(new Mensaje("Educacion creada"), HttpStatus.OK);
                
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoCurso dtocurso){
        if(!sCurso.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        if(sCurso.existsByNombreCurso(dtocurso.getNombreCurso()) && sCurso.getByNmbreC(dtocurso.getNombreCurso()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        if(StringUtils.isBlank(dtocurso.getNombreCurso())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        
        Curso educacion = sCurso.getOne(id).get();
        
        educacion.setNombreCurso(dtocurso.getNombreCurso());
        educacion.setTitulo(dtocurso.getTitulo());
        educacion.setFechaInicio(dtocurso.getFechaInicio());
        educacion.setFechaFin(dtocurso.getFechaFin());
        
        sCurso.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educacion actualizada"), HttpStatus.OK);
    }
}
