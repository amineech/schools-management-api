package com.amineechhibou.schoolsmgmt.DTOs;

public record SchoolDTO(
    String name
) {
    // I did not use a SchoolRepsonseDTO file because I don't need to add several representations later
    // to the SchoolDTO, I just need the name of the school.   
}
