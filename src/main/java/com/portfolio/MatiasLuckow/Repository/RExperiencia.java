package com.portfolio.MatiasLuckow.Repository;

import com.portfolio.MatiasLuckow.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RExperiencia extends JpaRepository <Experiencia, Integer> {
    public Optional<Experiencia> findByNombreE(String nombreExperiencia);
    public boolean existsByNombreE(String nombreExperiencia);
}
