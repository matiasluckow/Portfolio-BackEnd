package com.portfolio.MatiasLuckow.Entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    private String nombreCurso;
    
    private String titulo;
    
    //private boolean esCursoActual;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    public Curso() {
    }

    public Curso(String nombreCurso, String titulo, Date fechaInicio, Date fechaFin) {
        this.nombreCurso = nombreCurso;
        this.titulo = titulo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
}
