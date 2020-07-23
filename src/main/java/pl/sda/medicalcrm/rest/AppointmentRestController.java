package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Appointment;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.AppointmentRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/appointments")
public class AppointmentRestController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping(path = "/appointments")
    public @ResponseBody Long createAppointment(@RequestBody @Valid Appointment appointment){
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

    @PostMapping(path = "/{patientId}/appointment")
    public @ResponseBody Long createAppointmentByPatient(@PathVariable Long patientId,
                                                         @RequestBody @Valid Appointment appointment){
        appointmentRepository.save(appointment);
        return appointment.getId();
    }

}
