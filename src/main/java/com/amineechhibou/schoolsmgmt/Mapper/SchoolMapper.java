package com.amineechhibou.schoolsmgmt.Mapper;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolResponseDTO;
import com.amineechhibou.schoolsmgmt.Model.School;

@Service
public class SchoolMapper {
    public static SchoolResponseDTO toDTO(School school) {
        return new SchoolResponseDTO(school.getId(), school.getName());
    }
    public static School toEntity(SchoolResponseDTO schoolDTO) {
        return new School(schoolDTO.name());
    }
}
