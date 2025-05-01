package com.amineechhibou.courseapp.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "schools")
public class School {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    // @JsonProperty("school_name") // to use in request body
    private String name;

    @OneToMany(
        mappedBy = "school",
        cascade = CascadeType.ALL

    )
    private List<Student> students;

    public School() {

    }

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /* ########################################### */

    public List<Student> getStudent() {
        return this.students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}

