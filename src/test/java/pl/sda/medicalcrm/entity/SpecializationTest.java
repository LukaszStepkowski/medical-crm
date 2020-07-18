package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class SpecializationTest {

    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void testCreateSpecialization(){

        var specialization = new Specialization("Ortodonta", "Dawid", "Nosal");
        em.persist(specialization);

        em.flush();
        em.clear();
        var readSpecialization = em.find(Specialization.class, specialization.getId());

        assertEquals(readSpecialization, specialization);
    }

}