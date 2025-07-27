package com.amineechhibou.schoolsmgmt.Mapper;

import com.amineechhibou.schoolsmgmt.DTOs.StudentDTO;
import com.amineechhibou.schoolsmgmt.Model.School;
import com.amineechhibou.schoolsmgmt.Model.Student;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolDTO;

@Service
public class StudentMapper {
    public static StudentDTO toDTO(Student student) {
        return new StudentDTO(
            student.getFirstname(),
            student.getLastname(),
            new SchoolDTO(student.getSchool().getName())
        );
    }
    
    // I did not add a method toEntity because I am not using DTO to persist
    // data, I am using it just for data retrieval and transfer
    // so I don't need to convert DTO to Entity
    // if I need to persist data, I will use the Entity directly for now
    // or I will create a separate Mapper for that purpose   
}
