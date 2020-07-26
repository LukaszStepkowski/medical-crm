package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Appointment;
import pl.sda.medicalcrm.service.AppointmentService;

import javax.validation.Valid;

@Controller
@RequestMapping("/appointments")
@CrossOrigin(origins = "http://localhost:4200")
public class AppointmentRestController {

    @Autowired
    private AppointmentService appointmentService;

    @PostMapping
    public @ResponseBody
    Long makeNewAppointment(@RequestBody @Valid Appointment appointment){
        return appointmentService.makeNewAppointment(appointment);
    }

    @DeleteMapping(path = "/{appointmentId}")
    public @ResponseBody String deleteAppointment(@PathVariable Long appointmentId) {
        return appointmentService.deleteAppointment(appointmentId);
    }

}
