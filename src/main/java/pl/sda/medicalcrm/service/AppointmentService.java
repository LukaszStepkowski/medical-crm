package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.Appointment;
import pl.sda.medicalcrm.repository.AppointmentRepository;
import pl.sda.medicalcrm.repository.ClinicRepository;
import pl.sda.medicalcrm.repository.SpecializationRepository;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    private boolean isAppointmentDateForUserAvailable(Appointment appointment){
        List<Appointment> allAppointments = (List<Appointment>) appointmentRepository.findAll();
        return allAppointments.stream().filter(p -> p.getUser().getId().equals(appointment.getUser().getId()))
                .anyMatch(q -> q.getAppointmentDate().equals(appointment.getAppointmentDate()));
    }

    @Transactional
    public Long makeNewAppointment(Appointment appointment, String patientId, String specializationId, String clinicId){
        appointment.setUser(userRepository.findById(Long.valueOf(patientId)).get());
        appointment.setSpecialization(specializationRepository.findById(Long.valueOf(specializationId)).get());
        appointment.setClinic(clinicRepository.findById(Long.valueOf(clinicId)).get());
        if (isAppointmentDateForUserAvailable(appointment)) return 0L;
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

    public String deleteAppointment(Long appointmentId){
        appointmentRepository.deleteById(appointmentId);
        return "Appointment Deleted";
    }

}

