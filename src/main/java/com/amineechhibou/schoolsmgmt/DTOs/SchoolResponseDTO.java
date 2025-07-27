package com.amineechhibou.schoolsmgmt.DTOs;

public record SchoolResponseDTO(
    Integer id,
    String name
) {
    // I did not use a SchoolRequestDTO file because I don't need it
    // I will use SchoolResponseDTO directly in the SchoolService and SchoolController
    // I have only the school's id and name fields for creating and retrieving schools data
}
