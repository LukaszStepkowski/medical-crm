package pl.sda.medicalcrm.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.dto.UserIdDto;
import pl.sda.medicalcrm.service.SpecializationService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public class SpecializationRestController {

    private final SpecializationService service;

    public SpecializationRestController(SpecializationService service) {
        this.service = service;
    }

    @GetMapping(path = "/{userid}/doctors")
    List<SpecializationDto> listSpecializations(@PathVariable UUID userId){return  service.}

    @PostMapping(path = "/{userId}/specialization")
    ResponseEntity<UserIdDto> createSpecialization(@PathVariable UUID userId,
                                                   @RequestBody @Valid SpecializationDto dto){
        service.crea(userId, dto.getTypeOfSpecialization());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }
}
