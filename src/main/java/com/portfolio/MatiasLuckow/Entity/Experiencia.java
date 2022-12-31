package com.portfolio.MatiasLuckow.Entity;

//import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
//import javax.persistence.Lob;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;

@Getter @Setter
@Entity
public class Experiencia {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    
    private String nombreE;
    
//    private String puesto;
    
//    private boolean esTrabajoActual;
    
//    @Temporal(TemporalType.DATE)
//    private Date fechaInicio;
    
//    @Temporal(TemporalType.DATE)
//    private Date fechaFin;
    
//    @Lob
    //@Column(length=1000)
    private String descripcionE;
    
//    private String imagen;
    
//    private String url;

    public Experiencia() {
    }

    public Experiencia(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
}
