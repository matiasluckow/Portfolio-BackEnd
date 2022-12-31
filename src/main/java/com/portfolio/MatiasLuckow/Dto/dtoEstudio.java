package com.portfolio.MatiasLuckow.Dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoEstudio {
    
    //@NotBlank
    private String institucion;
    
    //@NotBlank
    private String titulo;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;

    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    
    private String imagen;
}
