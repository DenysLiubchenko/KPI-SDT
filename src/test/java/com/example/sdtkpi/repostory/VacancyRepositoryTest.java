package com.example.sdtkpi.repostory;

import com.example.sdtkpi.entity.Position;
import com.example.sdtkpi.entity.Vacancy;
import com.example.sdtkpi.repository.VacancyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class VacancyRepositoryTest {
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private PositionRepository positionRepository;

    @Test
    public void VacancyRepository_findAllByStatus_returnedAllTrueStatus () {
        List<Vacancy> vacancyList = generateVacancies(4);

        vacancyRepository.saveAll(vacancyList);

        List<Vacancy> returnedVacancies = vacancyRepository.findAllByStatus(true);

        Assertions.assertEquals(2, returnedVacancies.size());
        Assertions.assertTrue(returnedVacancies.get(0).isStatus());
        Assertions.assertTrue(returnedVacancies.get(1).isStatus());

    }

    private List<Vacancy> generateVacancies(int num) {
        List<Vacancy> vacancyList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Vacancy vacancy = new Vacancy();
            Position position = new Position();
            position.setJobTile("Test " + i);
            position.setSalary((double) i);
            vacancy.setPosition(positionRepository.save(position));
            vacancy.setStatus(i % 2 == 0);
            vacancyList.add(vacancy);
        }
        return vacancyList;
    }
}
