package com.amineechhibou.schoolsmgmt.Controlller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolDTO;
import com.amineechhibou.schoolsmgmt.Model.School;
import com.amineechhibou.schoolsmgmt.Repository.SchoolRepository;
import com.amineechhibou.schoolsmgmt.Service.SchoolService;

import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/schools")
public class SchoolController {
    
    private final SchoolRepository schoolRepository;
    private final SchoolService schoolService;

    public SchoolController(
        SchoolRepository schoolRepository,
        SchoolService schoolService) {
        this.schoolRepository = schoolRepository;
        this.schoolService = schoolService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<?> findAllSchools() {
        // get all schools by using the DTO pattern approach
        // getting only the school's name
        List<SchoolDTO> schools = schoolService.getAllSchools();

        if(schools.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(schools);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("There is no schools in the database !");    
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<?> findSchoolById(@PathVariable Integer id) {

        Optional<School> school = schoolRepository.findById(id);

        if(school.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(school);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("The schhol with id = " + id + " not found !");
    }

    @GetMapping("/search")
    public ResponseEntity<?> getSchoolsByName(@RequestParam String name) {
        
        List<School> schools = schoolRepository.findAllByNameContaining(name);
        if(schools.size() > 0) {
            return ResponseEntity.status(HttpStatus.OK)
                                .body(schools);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("No Schools containing the name " + name + " !");
    }
    
    
    @PostMapping({"", "/"})
    public ResponseEntity<?> createSchool(@RequestBody School school) {
        
        schoolRepository.save(school);
        
        return ResponseEntity.status(HttpStatus.OK)
                            .body("Record Created successfully !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSchool(@PathVariable Integer id) {

        Optional<School> school = schoolRepository.findById(id);

        if(school.isPresent()) {
            schoolRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK)
                                .body("School deleted successfully !");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("School with id = " + id +" not found !");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSchool(@PathVariable Integer id, @RequestBody School _school) {

        Optional<School> school = schoolRepository.findById(id);

        if(school.isPresent()) {
            School school_update = school.get();
            school_update.setName(_school.getName());
            schoolRepository.save(school_update);
            return ResponseEntity.status(HttpStatus.OK)
                                .body("Record updated Successfully !");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                            .body("School with id " + id + " not found !");
    }
}
