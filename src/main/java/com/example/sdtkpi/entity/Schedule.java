package com.example.sdtkpi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;
import java.util.List;

@Embeddable
public class Schedule {
    private Timestamp date;
    private List<String> tasks;
}
