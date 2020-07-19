package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.time.LocalDateTime;

@SpringBootTest
@Transactional
public class CreatePrescriptionTest {

    @Autowired
    private EntityManager em;

    @Test
    void CreatePrescriptionTest() {

    //given
        var prescription = new Prescription(1234, "description");

    //when
        em.persist(prescription);
        em.flush();
        em.clear();
    var readPrescription = em.find(Prescription.class,prescription.getId());

    //then
        Assertions.assertEquals(readPrescription.getId(), prescription.getId());
}
}
