package com.example.sdtkpi.controller;

import com.example.sdtkpi.dto.VacancyDto;
import com.example.sdtkpi.entity.Vacancy;
import com.example.sdtkpi.service.EmployeeDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/department/employee")
public class EmployeeDepartmentController {
    private final EmployeeDepartmentService employeeDepartmentService;

    @Autowired
    public EmployeeDepartmentController(EmployeeDepartmentService employeeDepartmentService) {
        this.employeeDepartmentService = employeeDepartmentService;
    }

    @GetMapping("/open")
    public List<VacancyDto> getOpenVacancies (Pageable pageable) {
        return employeeDepartmentService.getVacanciesByStatus(true, pageable);
    }
}
