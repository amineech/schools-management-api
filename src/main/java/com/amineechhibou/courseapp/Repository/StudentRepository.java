package com.amineechhibou.courseapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amineechhibou.courseapp.Model.Student;
                                                                
public interface StudentRepository extends JpaRepository<Student, Integer> { 

    // list of students containing "firstname" value in firstname  
    List<Student> findAllByFirstnameContaining(String firstname);
    // list of students by age
    List<Student> findAllByAge(Integer age); 
    
}
