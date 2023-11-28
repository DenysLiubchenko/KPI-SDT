package com.example.sdtkpi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "position")
@NoArgsConstructor
@Getter
@Setter
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Value must not be null")
    @Column(nullable = false, unique = true)
    private String jobTile;
    @NotNull(message = "Value must not be null")
    @Column(nullable = false, unique = true)
    private Double salary;
}
