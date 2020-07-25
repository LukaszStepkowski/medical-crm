package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.service.DoctorService;

import javax.validation.Valid;

@Controller
@RequestMapping("/doctors")
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorRestController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public @ResponseBody
    Long registerNewCrmSpecialist(@RequestBody @Valid Doctor doctor) {
        return doctorService.registerNewDoctor(doctor);
    }

    @PutMapping(path = "/{userId}")
    public @ResponseBody Long changeCrmSpecialistData(@PathVariable Long userId,
                                                      @RequestBody @Valid Doctor doctor) {
        return doctorService.changeDoctorData(userId, doctor);
    }
}
