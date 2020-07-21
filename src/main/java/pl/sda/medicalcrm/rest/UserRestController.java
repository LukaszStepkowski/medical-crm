package pl.sda.medicalcrm.rest;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.dto.*;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.UserRepository;
import pl.sda.medicalcrm.service.UserService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserRestController {

//    private final UserService service;

//    public UserRestController(UserService service) {
//        this.service = service;
//    }

    @Autowired
    private UserRepository userRepository;

    @PostMapping (path = "/patients")
    public @ResponseBody Long createPatient(@RequestBody @Valid Patient patient) {
        userRepository.save(patient);
        return patient.getId();
    }

//    @PostMapping (path = "/patients")
//    ResponseEntity<UserIdDto> createPatientWithSendingEmail(@RequestBody @Valid CreatePatientDto dto) throws MailjetSocketTimeoutException, MailjetException {
//        var id = service.createPatientWithSendingEmail(dto);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(new UserIdDto(id));
//    }

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

//    @PatchMapping(path = "/patients/{userId}/password")
//    ResponseEntity<UserIdDto>changePatientPassword(@PathVariable UUID userId,
//                                                 @RequestBody @Valid ChangePatientPasswordDto dto){
//        service.changePatientPassword(userId, dto.getPassword());
//        return  ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(path = "/doctors/{userId}/password")
//    ResponseEntity<UserIdDto>changeDoctorPassword(@PathVariable UUID userId,
//                                                   @RequestBody @Valid ChangeDoctorPasswordDto dto){
//        service.changeDoctorPassword(userId, dto.getPassword());
//        return  ResponseEntity.ok().build();
//    }
//
//    @PatchMapping(path = "/crmspecialists/{userId}/password")
//    ResponseEntity<UserIdDto>changeCrmSpecialistPassword(@PathVariable UUID userId,
//                                                  @RequestBody @Valid ChangeCrmSpecialistPasswordDto dto){
//        service.changeCrmSpecialistPassword(userId, dto.getPassword());
//        return  ResponseEntity.ok().build();
//    }
}
