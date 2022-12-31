package com.portfolio.MatiasLuckow.Repository;

import com.portfolio.MatiasLuckow.Entity.Red;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRed extends JpaRepository <Red, Integer>{
    
}
