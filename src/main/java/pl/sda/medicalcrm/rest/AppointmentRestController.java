package pl.sda.medicalcrm.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.medicalcrm.service.appointment.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentRestController {

    private final AppointmentService service;

    public AppointmentRestController(AppointmentService service) {
        this.service = service;
    }
}
