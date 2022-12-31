package com.portfolio.MatiasLuckow.Service;

import com.portfolio.MatiasLuckow.Entity.Curso;
import com.portfolio.MatiasLuckow.Repository.RCurso;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SCurso {

@Autowired
    RCurso rCurso;
    
    public List<Curso> list(){
        return rCurso.findAll();
    }
    
    public Optional<Curso> getOne(int id){
        return rCurso.findById(id);
    }
    
    public Optional<Curso> getByNmbreC(String nombreCurso){
        return rCurso.findBynombreCurso(nombreCurso);
    }
    
    public void save(Curso curso){
        rCurso.save(curso);
    }
    
    public void delete(int id){
        rCurso.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rCurso.existsById(id);
    }
    
    public boolean existsByNombreCurso(String nombreCurso){
        return rCurso.existsBynombreCurso(nombreCurso);
    }
}
