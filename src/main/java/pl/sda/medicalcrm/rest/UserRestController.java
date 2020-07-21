package pl.sda.medicalcrm.rest;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.dto.*;
import pl.sda.medicalcrm.entity.Admin;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.Patient;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.UserRepository;
import pl.sda.medicalcrm.service.UserService;

import javax.validation.Valid;
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
//
//    @PutMapping(path = "/patients/{userId}")
//    ResponseEntity<UserIdDto>changePatientEntity(@PathVariable UUID userId,
//                                                 @RequestBody @Valid ChangeUserPatientDto dto){
//        service.changePatientEntity(userId,dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname(), dto.getPesel());
//        return  ResponseEntity.ok().build();
//    }
//
//    @PostMapping(path = "/crmspecialists")
//    ResponseEntity<UserIdDto> createCrmSpecialist(@RequestBody @Valid CreateCrmSpecialistDto dto) {
//        var id = service.createCrmSpecialist(dto);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(new UserIdDto(id));
//    }

    @PostMapping(path = "/doctors")
    public @ResponseBody Long createDoctor(@RequestBody @Valid Doctor doctor) {
        userRepository.save(doctor);
        return doctor.getId();
    }

//    @PutMapping(path = "/doctors/{userId}")
//    ResponseEntity<UserIdDto> changeDoctorEntity(@PathVariable UUID userId,
//                                           @RequestBody @Valid ChangeUserDoctorDto dto) {
//
//        service.changeDoctorEntity(userId,dto.getLogin(), dto.getPassword(), dto.getNpwz(), dto.getName(), dto.getSurname());
//        return ResponseEntity.ok().build();
//    }

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
