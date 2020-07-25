package pl.sda.medicalcrm.rest;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.service.EmailService;
import pl.sda.medicalcrm.service.PatientService;

import javax.validation.Valid;

@Controller
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientRestController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private EmailService emailService;

    @PostMapping
    public @ResponseBody Long RegisterNewPatient(@RequestBody @Valid Patient patient)
            throws MailjetException, MailjetSocketTimeoutException {

        Long response = patientService.registerNewPatient(patient);
        if (response != 0) emailService.sendEmail(patient);
        return response;
    }

    @PutMapping(path = "/{userId}")
    public @ResponseBody Long changePatientData(@PathVariable Long userId,
                                                 @RequestBody @Valid Patient patient){
        return patientService.changePatientData(userId, patient);
    }

}