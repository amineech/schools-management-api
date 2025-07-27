package com.amineechhibou.schoolsmgmt.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amineechhibou.schoolsmgmt.DTOs.SchoolResponseDTO;
import com.amineechhibou.schoolsmgmt.Mapper.SchoolMapper;
import com.amineechhibou.schoolsmgmt.Model.School;
import com.amineechhibou.schoolsmgmt.Repository.SchoolRepository;

@Service
public class SchoolService {

    public final SchoolRepository schoolRepository;

    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolResponseDTO saveSchool(SchoolResponseDTO schoolDTO) {
        School school = SchoolMapper.toEntity(schoolDTO);
        return SchoolMapper.toDTO(schoolRepository.save(school));
    }

    public List<SchoolResponseDTO> getAllSchools() {
        return schoolRepository.findAll()
                                .stream()
                                .map(SchoolMapper::toDTO)
                                .toList();
    }
}
