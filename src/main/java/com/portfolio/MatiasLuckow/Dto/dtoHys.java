package com.portfolio.MatiasLuckow.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoHys {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;
}
