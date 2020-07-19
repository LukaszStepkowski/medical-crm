package pl.sda.medicalcrm.service.appointment;

import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.CreatePatientDto;
import pl.sda.medicalcrm.dto.appointment.CreateAppointmentDto;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.AppointmentRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class AppointmentService {


    private final AppointmentRepository repository;

    public AppointmentService(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UUID createAppointment(CreateAppointmentDto dto, Patient patient,
                                  Specialization specialization, Clinic clinic, Prescription prescription) {
        var appointment = new Appointment(dto.getAppointmentDate(), patient, specialization, clinic, dto.isOnline(), prescription);
        repository.save(appointment);
        return appointment.getId();

    }


}

