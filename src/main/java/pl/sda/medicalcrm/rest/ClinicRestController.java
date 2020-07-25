package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Clinic;
import pl.sda.medicalcrm.repository.AddressRepository;
import pl.sda.medicalcrm.repository.ClinicRepository;

import javax.validation.Valid;



@Controller
@RequestMapping(path = "/clinics")
public class ClinicRestController {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressRestController addressRestController;

    @PostMapping
    public @ResponseBody
    Long createClinic(@RequestBody @Valid Address address) {

        addressRepository.save(address);

        Clinic clinic = new Clinic();
        clinic.setAddress(address);
        clinicRepository.save(clinic);
        return clinic.getId();
    }
}


