package com.example.sdtkpi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
    private Long id;
    @NotNull(message = "Value must not be null")
    @Column
    private String jobTile;
    @NotNull(message = "Value must not be null")
    @Column
    private Double salary;
}
