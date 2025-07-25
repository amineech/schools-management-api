package com.amineechhibou.schoolsmgmt.DTOs;

public record StudentDTO(
    String firstname,
    String lastname,
    SchoolDTO school
) {

}
