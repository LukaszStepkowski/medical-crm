package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Clinic;
import pl.sda.medicalcrm.repository.AddressRepository;
import pl.sda.medicalcrm.repository.ClinicRepository;
import pl.sda.medicalcrm.service.AddressService;
import pl.sda.medicalcrm.service.ClinicService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(path = "/clinics")
public class ClinicRestController {


    @Autowired
    private AddressService addressService;

    @Autowired
    private ClinicService clinicService;

    @GetMapping
    public @ResponseBody
    List<Clinic> listClinic() {
        return clinicService.getListOfAllClinics();
    }

    @PostMapping
    public @ResponseBody
    Long createClinic(@RequestBody @Valid Clinic clinic) {
        return clinicService.createClinic(clinic);
    }

    @PutMapping(path = "/{clinicId}/{addressId}")
    public @ResponseBody
    Long setClinicAddress(@PathVariable Long clinicId,
                          @PathVariable Long addressId,
                          @RequestBody @Valid Clinic clinic,
                          @RequestBody @Valid Address address) {

        clinic.setId(clinicId);
        clinic.setAddress(address);
        return clinicService.saveClinic(clinic);
    }
}







