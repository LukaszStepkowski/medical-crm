package pl.sda.medicalcrm.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class UserPasswordModifyTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void testPatientPasswordModify() {
        //given
        var patient = new Patient("login", "password", "Jan", "Kowalski", "123456789");
        repository.saveAndFlush(patient);
        em.clear();

        //when
        int updated = repository.updatePatientPassword(patient.getId(), "newPassword");
        repository.flush();

        //then
        assertEquals(1, updated);
        var user = repository.findById(patient.getId()).get();
        assertEquals("newPassword", user.getPassword());
    }

    @Test
    void testDoctorPasswordModify() {
        //given
        var doctor = new Doctor("login", "password", "Jan", "Kowalski", "123456789");
        repository.saveAndFlush(doctor);
        em.clear();

        //when
        int updated = repository.updateDoctorPassword(doctor.getId(), "newDoctorPassword");
        repository.flush();

        //then
//        assertEquals(1, updated);
        var user = repository.findById(doctor.getId()).get();
        assertEquals("newDoctorPassword", user.getPassword());
    }
}