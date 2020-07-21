package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.medicalcrm.repository.AppointmentRepository;

@Controller
@RequestMapping("/appointments")
public class AppointmentRestController {

    @Autowired
    private AppointmentRepository appointmentRepository;
}
