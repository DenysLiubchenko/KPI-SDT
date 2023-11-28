package com.example.sdtkpi.service;

import com.example.sdtkpi.entity.Department;
import com.example.sdtkpi.entity.Employee;
import com.example.sdtkpi.entity.Vacancy;
import com.example.sdtkpi.repository.DepartmentRepository;
import com.example.sdtkpi.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class EmployeeDepartmentService extends DepartmentService {

    private final VacancyRepository vacancyRepository;

    @Autowired
    public EmployeeDepartmentService(DepartmentRepository departmentRepository, VacancyRepository vacancyRepository) {
        super(departmentRepository);
        this.vacancyRepository = vacancyRepository;
    }

    public List<Employee> getEmployees () {
        return super.departmentRepository.findAll().stream().map(Department::getEmployees).flatMap(Collection::stream).toList();
    }

    public List<Vacancy> getVacancies () {
        return vacancyRepository.findAll();
    }

    public List<Vacancy> getVacanciesByStatus (boolean status) {
        return vacancyRepository.findAllByStatus(status);
    }
}
