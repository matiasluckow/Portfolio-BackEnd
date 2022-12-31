package com.portfolio.MatiasLuckow.Repository;

import com.portfolio.MatiasLuckow.Entity.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RPersona extends JpaRepository <Persona, Integer>{
    Optional<Persona> findByNombreCompleto(String nombreCpmpleto);
    public boolean existsByNombreCompleto(String nombreCompleto);
}
