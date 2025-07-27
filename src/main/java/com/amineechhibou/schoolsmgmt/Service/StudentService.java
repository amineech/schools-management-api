package com.amineechhibou.schoolsmgmt.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.StudentRequestDTO;
import com.amineechhibou.schoolsmgmt.DTOs.StudentResponseDTO;
import com.amineechhibou.schoolsmgmt.Mapper.SchoolMapper;
import com.amineechhibou.schoolsmgmt.Mapper.StudentMapper;
import com.amineechhibou.schoolsmgmt.Model.School;
import com.amineechhibou.schoolsmgmt.Model.Student;
import com.amineechhibou.schoolsmgmt.Repository.SchoolRepository;
import com.amineechhibou.schoolsmgmt.Repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    public StudentService(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;   
    }

    public Student saveStudent(StudentRequestDTO studentRequestDTO) {
        School school = schoolRepository.findById(studentRequestDTO.school().id())
                .orElseThrow(() -> new IllegalArgumentException("School not found with id: " + studentRequestDTO.school().id()));
                
        Student student = StudentMapper.toEntity(studentRequestDTO, school);
        return studentRepository.save(student);
    }

    public List<StudentResponseDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        
        return toListDTO(students);
    }

    public Optional<StudentResponseDTO> getStudentById(Integer id) {
        return studentRepository.findById(id)
                                .map(StudentMapper::toDTO);
    }

    public List<StudentResponseDTO> getStudentsByAge(Integer age) {
        List<Student> students = studentRepository.findAllByAge(age);
        return toListDTO(students); 
    }
    public List<StudentResponseDTO> getStudentsByFirstnameContaining(String firstname) {
        List<Student> students = studentRepository.findAllByFirstnameContaining(firstname);
        return toListDTO(students); 
    }

    // internal method to convert to a list of StudentDTO
    public List<StudentResponseDTO> toListDTO(List<Student> students) {
        return students.stream()
                        .map(StudentMapper::toDTO)
                        .toList();
    }
}
