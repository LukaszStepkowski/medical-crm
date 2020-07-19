package pl.sda.medicalcrm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.dto.UserIdDto;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.service.specialization.SpecializationService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;
@RestController
public class SpecializationRestController {

    private final SpecializationService service;

    public SpecializationRestController(SpecializationService service) {
        this.service = service;
    }

    @GetMapping(path = "/specializations")
    List<SpecializationDto> listSpecializations(){return  service.listSpecialization();}

    @PostMapping(path = "/specializations")
    ResponseEntity<UserIdDto> createSpecialization(@RequestBody @Valid SpecializationDto dto){
        Specialization specialization = service.createSpecialization(dto.getTypeOfSpecialization());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

/*
    @GetMapping(path = "/{doctorId}/specializations")
    List<SpecializationDto> listSpecializations(@PathVariable UUID doctorId) {
        return service.listSpecialization(doctorId);
    }*/

    @PostMapping(path = "/{doctorId/specializations")
    ResponseEntity<UserIdDto> connectSpecializationDoctor(@PathVariable UUID doctorId,
                                                          @RequestBody @Valid  UUID specializationId) {

        service.connectSpecializationDoctor(doctorId,specializationId);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
