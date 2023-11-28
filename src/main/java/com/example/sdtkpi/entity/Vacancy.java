package com.example.sdtkpi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "vacancy")
@NoArgsConstructor
@Getter
@Setter
public class Vacancy {
    @Id
    private Long id;

    @NotNull(message = "Value must not be null")
    @ManyToOne
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;
    @NotNull(message = "Value must not be null")
    @Column
    private boolean status;
}
