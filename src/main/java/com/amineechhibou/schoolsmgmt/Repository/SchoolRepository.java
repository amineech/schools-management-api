package com.amineechhibou.schoolsmgmt.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.amineechhibou.schoolsmgmt.Model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    
    // list of schools containing "name" in their name
    List<School> findAllByNameContaining(String name);


}
