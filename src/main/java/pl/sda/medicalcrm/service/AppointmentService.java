package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.Appointment;
import pl.sda.medicalcrm.repository.AppointmentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    private boolean isAppointmentDateForUserAvailable(Appointment appointment){
        List<Appointment> allAppointments = (List<Appointment>) appointmentRepository.findAll();
        return allAppointments.stream().filter(p -> p.getUser().getId().equals(appointment.getUser().getId()))
                .anyMatch(q -> q.getAppointmentDate().equals(appointment.getAppointmentDate()));
    }

    @Transactional
    public Long makeNewAppointment(Appointment appointment){
        if (isAppointmentDateForUserAvailable(appointment)) return 0L;
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

}

