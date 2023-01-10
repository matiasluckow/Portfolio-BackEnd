package com.portfolio.MatiasLuckow.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class dtoLogoArgProg {
    
    @NotBlank
    private String imagen;
    
}
