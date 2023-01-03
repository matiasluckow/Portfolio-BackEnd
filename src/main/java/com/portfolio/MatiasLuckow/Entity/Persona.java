package com.portfolio.MatiasLuckow.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    private String nombreCompleto;
    
    
    private String titulo;

    private String domicilio;

    @Temporal(TemporalType.DATE)
    private Date fechaNac;

    private String sobreMi;

    private String foto;

    public Persona() {
    }

    public Persona(String nombreCompleto, String titulo, String domicilio, Date fechaNac, String sobreMi, String foto) {
        this.nombreCompleto = nombreCompleto;
        this.titulo = titulo;
        this.domicilio = domicilio;
        this.fechaNac = fechaNac;
        this.sobreMi = sobreMi;
        this.foto = foto;
    }
}