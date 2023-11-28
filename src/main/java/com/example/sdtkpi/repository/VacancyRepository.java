package com.example.sdtkpi.repository;

import com.example.sdtkpi.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    @Query("select distinct v from Vacancy v left join fetch v.position")
    List<Vacancy> findAllBy ();
    @Query("select distinct v from Vacancy v left join fetch v.position where v.status = true")
    List<Vacancy> findAllByStatus (boolean status);
}
