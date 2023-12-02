package com.example.sdtkpi.service;

import com.example.sdtkpi.dto.VacancyDto;
import com.example.sdtkpi.entity.Vacancy;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface EmployeeDepartmentService extends DepartmentService {

//    List<Employee> getEmployees ();
//    List<Vacancy> getVacancies ();
    List<VacancyDto> getVacanciesByStatus (boolean status, Pageable pageable);
//    Vacancy createVacancy (Vacancy vacancy);
}
