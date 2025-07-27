package com.amineechhibou.schoolsmgmt.Mapper;

import com.amineechhibou.schoolsmgmt.DTOs.StudentResponseDTO;
import com.amineechhibou.schoolsmgmt.Model.School;
import com.amineechhibou.schoolsmgmt.Model.Student;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolResponseDTO;
import com.amineechhibou.schoolsmgmt.DTOs.StudentRequestDTO;

@Service
public class StudentMapper {
    public static StudentResponseDTO toDTO(Student student) {
        return new StudentResponseDTO(
            student.getFirstname(),
            student.getLastname(),
            new SchoolResponseDTO(student.getSchool().getId(), student.getSchool().getName())
        );
    }
    
    public static Student toEntity(StudentRequestDTO studentRequestDTO, School school) {
        Student student = new Student();
        student.setFirstname(studentRequestDTO.firstname());
        student.setLastname(studentRequestDTO.lastname());      
        student.setEmail(studentRequestDTO.email());
        student.setAge(studentRequestDTO.age());
        student.setSchool(school);
        return student;
    }
}
