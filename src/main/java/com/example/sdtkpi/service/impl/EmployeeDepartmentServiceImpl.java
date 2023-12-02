package com.example.sdtkpi.service.impl;

import com.example.sdtkpi.dto.VacancyDto;
import com.example.sdtkpi.entity.Vacancy;
import com.example.sdtkpi.repository.DepartmentRepository;
import com.example.sdtkpi.repository.VacancyRepository;
import com.example.sdtkpi.service.EmployeeDepartmentService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
@Transactional
public class EmployeeDepartmentServiceImpl extends DepartmentServiceImpl implements EmployeeDepartmentService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public EmployeeDepartmentServiceImpl(DepartmentRepository departmentRepository, VacancyRepository vacancyRepository) {
        super(departmentRepository);
        this.vacancyRepository = vacancyRepository;
    }
    public List<VacancyDto> getVacanciesByStatus (boolean status, Pageable pageable) {
        return vacancyRepository.findAllByStatus(status, pageable);
    }
}
