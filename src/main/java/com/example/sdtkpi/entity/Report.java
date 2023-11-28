package com.example.sdtkpi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "report")
@NoArgsConstructor
@Getter
@Setter
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Value must not be null")
    @Column(nullable = false)
    private Timestamp date = Timestamp.valueOf(LocalDateTime.now());
    @NotBlank(message = "Value must not be blank")
    @Column(nullable = false)
    private String file;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
