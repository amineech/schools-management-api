package com.amineechhibou.schoolsmgmt.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolDTO;
import com.amineechhibou.schoolsmgmt.Mapper.SchoolMapper;
import com.amineechhibou.schoolsmgmt.Repository.SchoolRepository;

@Service
public class SchoolService {

    public final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public List<SchoolDTO> getAllSchools() {
        return schoolRepository.findAll()
                                .stream()
                                .map(SchoolMapper::toDTO)
                                .toList();
    }
}
