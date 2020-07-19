package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class CreateExaminationTest {

    @Autowired
    private EntityManager em;

    @Test
    void createAppointmentTest() {
        //given
        var examination = new Examination("examination_type", "result", "description");

        //when
        em.persist(examination);
        em.flush();
        em.clear();
        var readExamination = em.find(Examination.class, examination.getId());

        //then
        Assertions.assertEquals(readExamination.getId(), examination.getId());
        Assertions.assertEquals(readExamination.getDescription(), examination.getDescription());
    }
}
