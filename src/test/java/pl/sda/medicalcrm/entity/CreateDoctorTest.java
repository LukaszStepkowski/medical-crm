package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.ConstraintViolationException;


import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CreateDoctorTest {
    @Autowired
    private EntityManager em;

    @Test
    @Transactional
    void testCreateDoctor() {

        //given

        var doctor = new Doctor("doctor1", "password", "1234567",
                "Jan", "Kowalski", "Optometrist");

        //when
        em.persist(doctor);
        em.flush();
        em.clear();

        var readDoctor = em.find(Doctor.class, doctor.getId());

        //then
        assertEquals(readDoctor, doctor);
    }

}