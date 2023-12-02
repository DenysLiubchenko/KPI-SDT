package com.example.sdtkpi.repostory;

import com.example.sdtkpi.dto.VacancyDto;
import com.example.sdtkpi.entity.Position;
import com.example.sdtkpi.entity.Vacancy;
import com.example.sdtkpi.repository.PositionRepository;
import com.example.sdtkpi.repository.VacancyRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.DirtiesContext;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class VacancyRepositoryTest {
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private PositionRepository positionRepository;

    @Test
    public void findAllByStatus_true_returnedAllTrueStatus () {
        List<Vacancy> vacancyList = generateVacancies(4);

        vacancyRepository.saveAll(vacancyList);
        List<VacancyDto> returnedVacancies = vacancyRepository.findAllByStatus(true, PageRequest.of(0,10));

        Assertions.assertEquals(2, returnedVacancies.size());
        Assertions.assertTrue(returnedVacancies.get(0).status());
        Assertions.assertTrue(returnedVacancies.get(1).status());
    }

    @Test
    public void findAllByStatus_whenNoEntitiesToFind_returnedEmptyList () {
        List<Vacancy> vacancyList = generateVacancies(4).stream().filter(Vacancy::isStatus).toList();

        vacancyRepository.saveAll(vacancyList);
        List<VacancyDto> returnedVacancies = vacancyRepository.findAllByStatus(false, PageRequest.of(0,10));

        Assertions.assertTrue(returnedVacancies.isEmpty());
    }

    @Test
    public void findAllBy_withNonemptyRepository_returnedAllTrueStatus () {
        List<Vacancy> vacancyList = generateVacancies(4);

        vacancyRepository.saveAll(vacancyList);
        List<VacancyDto> returnedVacancies = vacancyRepository.findAllBy(PageRequest.of(0,10));

        Assertions.assertEquals(4, returnedVacancies.size());
        for (int i = 0; i < vacancyList.size(); i++) {
            Assertions.assertEquals(returnedVacancies.get(i).positionJobTile(), vacancyList.get(i).getPosition().getJobTile());
        }
    }

    @Test
    public void findAllBy_withEmptyRepository_returnedEmptyList () {
        List<VacancyDto> returnedVacancies = vacancyRepository.findAllBy(PageRequest.of(0,10));

        Assertions.assertTrue(returnedVacancies.isEmpty());
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
