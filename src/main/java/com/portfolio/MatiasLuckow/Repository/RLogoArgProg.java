package com.portfolio.MatiasLuckow.Repository;

import com.portfolio.MatiasLuckow.Entity.LogoArgProg;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RLogoArgProg extends JpaRepository <LogoArgProg, Integer>{
    Optional<LogoArgProg> findByImagen(String imagen);
    public boolean existsByImagen(String imagen);
}
