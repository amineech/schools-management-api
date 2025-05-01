package com.amineechhibou.courseapp.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.amineechhibou.courseapp.Model.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
    
    // list of schools containing "school_name" in their name
    List<School> findAllByNameContaining(String school_name);


}
