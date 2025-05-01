package com.amineechhibou.schoolsmgmt.Controlller;


import java.util.List;
import java.util.Optional;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.amineechhibou.schoolsmgmt.Model.Student;
import com.amineechhibou.schoolsmgmt.Repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> findAllStudents() {
        
        List<Student> students = studentRepository.findAll();

        if(students.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(students);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("There is no students in the database !");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findStudentById(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id); 
        if(student.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(student);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("the student with id = " + id + " not found !");
    }

    @GetMapping("/search/firstname/{firstname}")
    public List<Student> findStudentsByFirstname(@PathVariable String firstname) {
        return studentRepository.findAllByFirstnameContaining(firstname);
    }
    
    @GetMapping("/search/age/{age}")
    public List<Student> findStudentsByFirstname(@PathVariable Integer age) {
        return studentRepository.findAllByAge(age);
    }

    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.OK)
                            .body("Record created successfully !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                                .body(("Student deleted successfully !"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Student with id = " + id + " not found !");
    }
    
    @PutMapping("/{id}") 
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student _student) {
        Optional<Student> student = studentRepository.findById(id);
        
        if(student.isPresent()) {
            Student student_update = student.get();

            student_update.setFirstname(_student.getFirstname());
            student_update.setLastname(_student.getLastname());
            student_update.setEmail(_student.getEmail());
            student_update.setAge(_student.getAge());
            
            studentRepository.save(student_update);

            return ResponseEntity.status(HttpStatus.OK)
                                .body("Record updated successfully !");
        }
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("Student with id = " + id + " not found !");
    }

}
