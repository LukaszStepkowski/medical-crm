package pl.sda.medicalcrm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.medicalcrm.dto.CreatePatientDto;
import pl.sda.medicalcrm.dto.UserIdDto;
import pl.sda.medicalcrm.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService service;

    public UserRestController(UserService service) {
        this.service = service;
    }

    @PostMapping
    ResponseEntity<UserIdDto> createPatient(@RequestBody @Valid CreatePatientDto dto) {
        var id = service.createPatient(dto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new UserIdDto(id));
    }
}
