package com.amineechhibou.schoolsmgmt.DTOs;

import org.springframework.format.annotation.NumberFormat;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public record StudentRequestDTO(

    @NotEmpty(message = "First name required !")
    String firstname,
    
    @NotEmpty(message = "Last name required !")
    String lastname,
    
    @NotEmpty(message = "Email require !")
    String email,

    @Min(value = 17, message = "minimum age is 18 !")
    Integer age,
    
    SchoolResponseDTO school
) {
    
}
