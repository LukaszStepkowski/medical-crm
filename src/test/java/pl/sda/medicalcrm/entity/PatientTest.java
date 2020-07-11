package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class PatientTest {

    @Autowired
    private EntityManager em;

    @Test
    void TestCreatePatient(){
        //given
        var patient = new Patient("login", "password", "Jan", "Kowalski", 123456789);

        //when
        em.persist(patient);
        em.flush();
        em.clear();
        var readPatient = em.find(Patient.class, patient.getId());

        //then
        Assertions.assertEquals(readPatient, patient);
    }
}
