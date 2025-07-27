package com.amineechhibou.schoolsmgmt.Mapper;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolDTO;
import com.amineechhibou.schoolsmgmt.Model.School;

@Service
public class SchoolMapper {
    public static SchoolDTO toDTO(School school) {
        return new SchoolDTO(school.getName());
    }
}
