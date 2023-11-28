package com.example.sdtkpi.service;

import com.example.sdtkpi.entity.Employee;
import com.example.sdtkpi.entity.Report;
import com.example.sdtkpi.entity.Request;
import com.example.sdtkpi.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    protected final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Employee> getDepartmentEmployees (String name) {
        return departmentRepository.findByDepartmentName(name).getEmployees();
    }

    public List<Report> getDepartmentReports (String name) {
        return departmentRepository.findByDepartmentName(name).getReports();
    }
    public List<Request> getDepartmentRequests (String name) {
        return departmentRepository.findByDepartmentName(name).getRequests();
    }
}
