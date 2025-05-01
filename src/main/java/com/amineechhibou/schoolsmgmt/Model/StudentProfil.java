package com.amineechhibou.schoolsmgmt.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name= "students_profile")
public class StudentProfil {

    @Id
    @GeneratedValue
    private Integer id;

    private String bio;

    // every profil belongs to one student
    @OneToOne()
    @JoinColumn(name = "student_id")
    private Student student;

    public StudentProfil() {
        // 
    }
    public StudentProfil(String bio) {
        this.bio = bio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    

}

