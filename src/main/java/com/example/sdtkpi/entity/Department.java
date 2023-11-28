package com.example.sdtkpi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "department")
@NoArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String departmentName;
    @OneToOne
    @JoinColumn(name = "manager_id")
    private Employee departmentManager;
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Report> reports;
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Request> requests;
    @OneToMany(mappedBy = "department", cascade = CascadeType.REMOVE)
    private List<Employee> employees;
}
