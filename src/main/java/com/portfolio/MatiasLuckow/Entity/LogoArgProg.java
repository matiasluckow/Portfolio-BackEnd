package com.portfolio.MatiasLuckow.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class LogoArgProg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String imagen;

    public LogoArgProg() {
    }

    public LogoArgProg(String imagen) {
        this.imagen = imagen;
    }
}
