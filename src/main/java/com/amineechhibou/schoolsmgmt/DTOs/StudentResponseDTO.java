package com.amineechhibou.schoolsmgmt.DTOs;

public record StudentResponseDTO(
    String firstname,
    String lastname,
    SchoolResponseDTO school
) {

    // I did not add StudentResponseDTO because I don't need it
    // I will use StudentDTO directly in the StudentService and StudentController, I need only the student's name and his school name
    // I will use the StudentMapper to convert the Student entity to StudentDTO
    // and vice versa if needed (not needed for now)
}
