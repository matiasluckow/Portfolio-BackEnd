package com.portfolio.MatiasLuckow.Controller;

import com.portfolio.MatiasLuckow.Dto.dtoLogoArgProg;
import com.portfolio.MatiasLuckow.Entity.LogoArgProg;
import com.portfolio.MatiasLuckow.Security.Controller.Mensaje;
import com.portfolio.MatiasLuckow.Service.SLogoArgProg;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("logo")  //localhost:8080/logo
@CrossOrigin(origins = "https://portfoliofrontend-37881.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CArgProg {
    
    @Autowired
    SLogoArgProg sLogoArgProg;

    @GetMapping("/lista")
    public ResponseEntity<List<LogoArgProg>> list() {
        List<LogoArgProg> list = sLogoArgProg.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<LogoArgProg> getById(@PathVariable("id") int id) {
        if (!sLogoArgProg.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        LogoArgProg logoargprog = sLogoArgProg.getOne(id).get();
        return new ResponseEntity(logoargprog, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sLogoArgProg.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        sLogoArgProg.delete(id);
        return new ResponseEntity(new Mensaje("Persona eliminada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoLogoArgProg dtologoargprog) {
        if (StringUtils.isBlank(dtologoargprog.getImagen())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatoria"), HttpStatus.BAD_REQUEST);
        }
        if (sLogoArgProg.existsByImagen(dtologoargprog.getImagen())) {
            return new ResponseEntity(new Mensaje("Esa imagen ya existe"), HttpStatus.BAD_REQUEST);
        }
     
        LogoArgProg logoargprog = new LogoArgProg (dtologoargprog.getImagen());
        sLogoArgProg.save(logoargprog);

        return new ResponseEntity(new Mensaje("Persona agregada"), HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')")   
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoLogoArgProg dtologoargprog) {
        //Validamos si existe el ID
        if (!sLogoArgProg.existsById(id)) {
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);
        }
        //Compara nombre de Persona
        if (sLogoArgProg.existsByImagen(dtologoargprog.getImagen()) && sLogoArgProg.getByImagen(dtologoargprog.getImagen()).get()
                .getId() != id) {
            return new ResponseEntity(new Mensaje("Esta imagen ya existe"), HttpStatus.BAD_REQUEST);
        }
        //No puede estar vacio
        if (StringUtils.isBlank(dtologoargprog.getImagen())) {
            return new ResponseEntity(new Mensaje("La imagen es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        LogoArgProg logoargprog = sLogoArgProg.getOne(id).get();
        
        logoargprog.setImagen(dtologoargprog.getImagen());
   
        sLogoArgProg.save(logoargprog);
        return new ResponseEntity(new Mensaje("Imagen actualizada"), HttpStatus.OK);

    }
}
