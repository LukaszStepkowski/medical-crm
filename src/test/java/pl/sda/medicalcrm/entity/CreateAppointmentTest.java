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
public class CreateAppointmentTest {

    @Autowired
    private EntityManager em;

    @Test
    void createAppointmentTest() {
        //given
        var patient = new Patient("login", "password", "Jan", "Kowalski", "123456789");
        var specialization = new Specialization("kardiolog");
        var address = new Address("street", "city", "zipCode", "Poland");
        LocalDateTime date = LocalDateTime.now();
        var clinic = new Clinic(address);
        var prescription = new Prescription(1234, "description");
        var appointment = new Appointment(date, patient, specialization, clinic, false, prescription);

        //when
        em.persist(appointment);
        em.flush();
        em.clear();
        var readAppointment = em.find(Appointment.class,appointment.getId());

        //then
        Assertions.assertEquals(readAppointment.getId(), appointment.getId());
        Assertions.assertEquals(readAppointment.getPatient().getName(), appointment.getPatient().getName());

        }
}
