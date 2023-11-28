package com.example.sdtkpi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "request")
@NoArgsConstructor
@Getter
@Setter
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String requestType;
    @NotNull(message = "Value must not be null")
    @Column(nullable = false)
    private boolean requestStatus;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String requestInfo;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
