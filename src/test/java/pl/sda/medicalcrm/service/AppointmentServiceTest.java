package pl.sda.medicalcrm.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.medicalcrm.dto.appointment.CreateAppointmentDto;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.AppointmentRepository;
import pl.sda.medicalcrm.service.appointment.AppointmentService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class AppointmentServiceTest {

    @Autowired
    private AppointmentService service;

    @Autowired
    private AppointmentRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void testCreateAppointment() {
        // given
        var date = LocalDateTime.now();
        var dto = new CreateAppointmentDto(date, true);
        var patient = new Patient("login", "password", "Jan", "Kowalski", "123456789");
        var specialization = new Specialization("kardiolog");
        var address = new Address("street", "city", "zipCode", "Poland");
        var clinic = new Clinic(address);
        var prescription = new Prescription(1234, "description");

        //when
        var id = service.createAppointment(dto, patient, specialization, clinic, prescription);

        //then
        var appointmentOptional = repository.findById(id);
        assertTrue(appointmentOptional.isPresent());


    }
}