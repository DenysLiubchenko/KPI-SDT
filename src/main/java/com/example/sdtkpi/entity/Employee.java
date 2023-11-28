package com.example.sdtkpi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String firstName;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String secondName;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
    @Embedded
    @NotNull(message = "Value must not be null")
    private Schedule schedule;
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    @Email
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false, unique = true)
    private String email;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
