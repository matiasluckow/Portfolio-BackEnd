package com.portfolio.MatiasLuckow.Security.Repository;

import com.portfolio.MatiasLuckow.Security.Entity.Rol;
import com.portfolio.MatiasLuckow.Security.Enums.RolNombre;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface iRolRepository extends JpaRepository<Rol, Integer>{
    Optional<Rol> findByRolNombre(RolNombre rolnombre);
}
