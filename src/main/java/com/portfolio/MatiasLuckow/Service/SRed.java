package com.portfolio.MatiasLuckow.Service;

import com.portfolio.MatiasLuckow.Entity.Red;
import com.portfolio.MatiasLuckow.Repository.RRed;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRed {

    @Autowired
    public RRed redRepo;

    public List<Red> verRedes() {
        List<Red> listaRedes = redRepo.findAll();
        return listaRedes;
    }

    public Red buscarRed(int id) {
        //Si no encuentra devuelve nulo (null)
        Red re = redRepo.findById(id).orElse(null);
        return re;
    }

    public void crearRed(Red re) {
        redRepo.save(re);
    }

    public void borrarRed(int id) {
        redRepo.deleteById(id);
    }

    public void editarRed(Red re) {
        redRepo.save(re);
    }
}
