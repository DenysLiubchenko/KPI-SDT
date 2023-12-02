package com.example.sdtkpi.service;

import com.example.sdtkpi.dto.VacancyDto;
import com.example.sdtkpi.repository.DepartmentRepository;
import com.example.sdtkpi.repository.VacancyRepository;
import com.example.sdtkpi.service.impl.EmployeeDepartmentServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class EmployeeDepartmentServiceTest {
    @Mock
    private VacancyRepository vacancyRepository;
    @InjectMocks
    private EmployeeDepartmentServiceImpl employeeDepartmentService;

    @Test
    public void getVacanciesByStatus_statusTrue_returnsAllWithStatusTrue() {
        List<VacancyDto> vacancyDtoList = new ArrayList<>();
        vacancyDtoList.add(new VacancyDto("TestJob1", 33.4, true));
        vacancyDtoList.add(new VacancyDto("TestJob2", 33.4, true));
        when(vacancyRepository.findAllByStatus(eq(true), any(Pageable.class))).thenReturn(vacancyDtoList);

        List<VacancyDto> returnedVacancyDtoList = employeeDepartmentService
                .getVacanciesByStatus(true, PageRequest.of(0,10));

        assertNotNull(returnedVacancyDtoList);
        assertEquals(2, returnedVacancyDtoList.size());
        assertEquals(vacancyDtoList, returnedVacancyDtoList);
    }

    @Test
    public void getVacanciesByStatus_statusTrueAndEmptyRepository_returnsEmptyList() {
        List<VacancyDto> vacancyDtoList = new ArrayList<>();
        when(vacancyRepository.findAllByStatus(eq(false), any(Pageable.class))).thenReturn(vacancyDtoList);

        List<VacancyDto> returnedVacancyDtoList = employeeDepartmentService
                .getVacanciesByStatus(true, PageRequest.of(0,10));

        assertNotNull(returnedVacancyDtoList);
        assertEquals(0, returnedVacancyDtoList.size());
    }
}
