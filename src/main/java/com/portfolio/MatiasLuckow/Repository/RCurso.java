package com.portfolio.MatiasLuckow.Repository;

import com.portfolio.MatiasLuckow.Entity.Curso;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RCurso extends JpaRepository <Curso, Integer>{
    public Optional<Curso> findBynombreCurso(String curso);
    public boolean existsBynombreCurso(String curso);
}
