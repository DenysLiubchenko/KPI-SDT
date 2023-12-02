package com.example.sdtkpi.repository;

import com.example.sdtkpi.dto.VacancyDto;
import com.example.sdtkpi.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<VacancyDto> findAllBy (Pageable pageable);
    List<VacancyDto> findAllByStatus (boolean status, Pageable pageable);
}
