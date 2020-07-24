package pl.sda.medicalcrm.rest;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.UserRepository;
import pl.sda.medicalcrm.service.EmailService;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "https://medical-crm-app.herokuapp.com/")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping (path = "/patients")
    public @ResponseBody Long createPatient(@RequestBody @Valid Patient patient)
            throws MailjetException, MailjetSocketTimeoutException {

        emailService.sendEmail(patient);
        userRepository.save(patient);
        return patient.getId();
    }

    @PutMapping(path = "/patients/{userId}")
    public @ResponseBody Long changePatientEntity(@PathVariable Long userId,
                                                 @RequestBody @Valid Patient patient){
        Optional<User> optionalPatient = userRepository.findById(userId);
        if (!optionalPatient.isPresent()) return 0L;

        patient.setId(userId);
        userRepository.save(patient);
        return patient.getId();
    }

    @PostMapping(path = "/crmspecialists")
    public @ResponseBody Long createCrmSpecialist(@RequestBody @Valid CrmSpecialist crmSpecialist) {
        userRepository.save(crmSpecialist);
        return crmSpecialist.getId();
    }

    @PostMapping(path = "/doctors")
    public @ResponseBody Long createDoctor(@RequestBody @Valid Doctor doctor) {
        userRepository.save(doctor);
        return doctor.getId();
    }

    @PutMapping(path = "/doctors/{userId}")
    public @ResponseBody Long changeDoctorEntity(@PathVariable Long userId,
                                           @RequestBody @Valid Doctor doctor) {

        Optional<User> optionalDoctor = userRepository.findById(userId);
        if (!optionalDoctor.isPresent()) return 0L;

        doctor.setId(userId);
        userRepository.save(doctor);
        return doctor.getId();
    }

    @PostMapping(path = "/admins")
    public @ResponseBody Long createAdmin(@RequestBody @Valid Admin admin) {
        userRepository.save(admin);
        return admin.getId();
    }

    @PutMapping(path = "/admins/{userId}")
    public @ResponseBody Long changeAdminEntity(@PathVariable Long userId,
                                                @RequestBody @Valid Admin admin) {

        Optional<User> optionalAdmin = userRepository.findById(userId);
        if (!optionalAdmin.isPresent()) return 0L;

        admin.setId(userId);
        userRepository.save(admin);
        return admin.getId();
    }

    @PutMapping(path = "crmspecialists/{userId}")
    public @ResponseBody Long changeCrmSepcialistEntity(@PathVariable Long userId,
                                                        @RequestBody @Valid CrmSpecialist crmSpecialist) {

        Optional<User> optionalCrmSpecialist = userRepository.findById(userId);
        if (!optionalCrmSpecialist.isPresent()) return 0L;

        crmSpecialist.setId(userId);
        userRepository.save(crmSpecialist);
        return crmSpecialist.getId();
    }
}