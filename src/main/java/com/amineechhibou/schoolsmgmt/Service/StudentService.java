package com.amineechhibou.schoolsmgmt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.StudentDTO;
import com.amineechhibou.schoolsmgmt.Mapper.StudentMapper;
import com.amineechhibou.schoolsmgmt.Model.Student;
import com.amineechhibou.schoolsmgmt.Repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
    }

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        
        return toListDTO(students);
    }

    public Optional<StudentDTO> getStudentById(Integer id) {
        return studentRepository.findById(id)
                                .map(StudentMapper::toDTO);
    }

    public List<StudentDTO> getStudentsByAge(Integer age) {
        List<Student> students = studentRepository.findAllByAge(age);
        return toListDTO(students); 
    }
    public List<StudentDTO> getStudentsByFirstnameContaining(String firstname) {
        List<Student> students = studentRepository.findAllByFirstnameContaining(firstname);
        return toListDTO(students); 
    }

    // internal method to convert to a list of StudentDTO
    public List<StudentDTO> toListDTO(List<Student> students) {
        return students.stream()
                        .map(StudentMapper::toDTO)
                        .toList();
    }
}
