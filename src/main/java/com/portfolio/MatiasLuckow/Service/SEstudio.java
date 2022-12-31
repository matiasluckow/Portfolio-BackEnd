package com.portfolio.MatiasLuckow.Service;

import com.portfolio.MatiasLuckow.Entity.Estudio;
import com.portfolio.MatiasLuckow.Repository.REstudio;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SEstudio {
    
    @Autowired
    REstudio rEstudio;
    
    public List<Estudio> list(){
        return rEstudio.findAll();
    }
    
    public Optional<Estudio> getOne(int id){
        return rEstudio.findById(id);
    }
    
    public Optional<Estudio> getByNmbreE(String nombreE){
        return rEstudio.findByInstitucion(nombreE);
    }
    
    public void save(Estudio educacion){
        rEstudio.save(educacion);
    }
    
    public void delete(int id){
        rEstudio.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rEstudio.existsById(id);
    }
    
    public boolean existsByNombreE(String nombreE){
        return rEstudio.existsByInstitucion(nombreE);
    }
}
