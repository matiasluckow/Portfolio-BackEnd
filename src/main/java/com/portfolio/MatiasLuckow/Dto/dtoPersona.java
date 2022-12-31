package com.portfolio.MatiasLuckow.Dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoPersona {
    @NotBlank
    private String nombreCompleto;

    @NotBlank
    private String titulo;

    @NotBlank
    private String domicilio;
    
    @NotBlank
    @Temporal(TemporalType.DATE)
    private Date fechaNac;
    
    @NotBlank
    private String sobreMi;
    
    @NotBlank
    private String foto;
}
