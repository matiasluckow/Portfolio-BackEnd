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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombreProyecto;
    
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(String nombreProyecto, Date fechaRealizacion, String descripcion) {
        this.nombreProyecto = nombreProyecto;
        this.fechaRealizacion = fechaRealizacion;
        this.descripcion = descripcion;
    }
}
