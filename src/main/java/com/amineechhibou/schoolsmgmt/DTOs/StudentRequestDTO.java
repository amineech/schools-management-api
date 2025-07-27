package com.amineechhibou.schoolsmgmt.DTOs;

public record StudentRequestDTO(
    String firstname,
    String lastname,
    String email,
    Integer age,
    SchoolResponseDTO school
) {
    
}
