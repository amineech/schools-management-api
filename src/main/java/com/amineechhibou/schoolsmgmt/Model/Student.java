package com.amineechhibou.schoolsmgmt.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "students")
public class Student {
    
    @Id
    @GeneratedValue
    private int id;

    @Column(length = 30)
    private String firstname;
    
    @Column(length = 30)
    private String lastname;
    
    @Column(unique = true, length = 50)
    private String email;
    
    @Column
    private int age;

    // every student has one and only profil
    @OneToOne(
        mappedBy = "student",
        cascade = CascadeType.ALL
    )
    private StudentProfil studentProfil;

    // every student is in one school
    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference 
    private School school;

    public Student() {
        // 
    }

    public Student(String firstname, String lastname, int age) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    /* ########################################### */

    public StudentProfil getStudentProfil() {
        return studentProfil;
    }

    public void setStudentProfil(StudentProfil studentProfil) {
        this.studentProfil = studentProfil;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
