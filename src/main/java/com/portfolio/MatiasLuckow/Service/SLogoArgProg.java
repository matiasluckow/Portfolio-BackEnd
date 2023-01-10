package com.portfolio.MatiasLuckow.Service;

import com.portfolio.MatiasLuckow.Entity.LogoArgProg;
import com.portfolio.MatiasLuckow.Repository.RLogoArgProg;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SLogoArgProg {
    
    @Autowired
    RLogoArgProg rLogoArgProg;
    
    public List<LogoArgProg> list(){
        return rLogoArgProg.findAll();
    }
    
    public Optional<LogoArgProg> getOne(int id){
        return rLogoArgProg.findById(id);
    }
    
    public Optional<LogoArgProg> getByImagen(String foto){
        return rLogoArgProg.findByImagen(foto);
    }
    
    public void save(LogoArgProg logo){
        rLogoArgProg.save(logo);
    }
    
    public void delete(int id){
        rLogoArgProg.deleteById(id);
    }
    
    public boolean existsById(int id){
        return rLogoArgProg.existsById(id);
    }
    
    public boolean existsByImagen(String foto){
        return rLogoArgProg.existsByImagen(foto);
    }    
 
}
