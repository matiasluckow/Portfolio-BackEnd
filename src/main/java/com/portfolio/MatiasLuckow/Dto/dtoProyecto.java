package com.portfolio.MatiasLuckow.Dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoProyecto {
    
    //@NotBlank
    private String nombreProyecto;
    
    @Temporal(TemporalType.DATE)
    private Date fechaRealizacion;
    
    @NotBlank
    private String descripcion;
}
