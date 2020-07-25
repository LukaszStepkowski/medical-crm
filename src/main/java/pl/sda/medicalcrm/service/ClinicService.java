package pl.sda.medicalcrm.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Clinic;
import pl.sda.medicalcrm.repository.ClinicRepository;

import javax.validation.Valid;

@Service
public class ClinicService {

    private ClinicRepository clinicRepository;

    @PostMapping
    public @ResponseBody
    Long createClinic(@RequestBody @Valid Address address) {

        Clinic clinic = new Clinic();
        clinic.setAddress(address);
        clinicRepository.save(clinic);
        return clinic.getId();
    }


}
