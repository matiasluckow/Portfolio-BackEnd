package com.portfolio.MatiasLuckow.Controller;

import com.portfolio.MatiasLuckow.Entity.Red;
import com.portfolio.MatiasLuckow.Service.SRed;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("red")  //localhost:8080/red
@CrossOrigin(origins = "https://portfoliofrontend-37881.web.app")
//@CrossOrigin(origins = "http://localhost:4200")
public class CRed {

    @Autowired
    SRed redServ;

    @GetMapping("/lista")
    @ResponseBody
    public List<Red> verRedes() {
        return redServ.verRedes();
    }

    @GetMapping("/ver/{id}")
    @ResponseBody
    public Red verRed(@PathVariable int id) {
        return redServ.buscarRed(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/crear")
    public String agregarRed(@RequestBody Red re) {
        redServ.crearRed(re);
        return "La red fue creada correctamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/borrar/{id}")
    public String eliminarRed(@PathVariable int id) {
        redServ.borrarRed(id);
        return "La red fue borrada correctamente";
    }

    //Otra forma de editar red
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar")
    public void actualizarRed(@RequestBody Red re) {
        redServ.editarRed(re);
    }

}
