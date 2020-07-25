package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Clinic;
import pl.sda.medicalcrm.repository.AddressRepository;
import pl.sda.medicalcrm.repository.ClinicRepository;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping(path = "/clinics")
public class ClinicRestController {

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressRestController addressRestController;


    @GetMapping
    public @ResponseBody
    List<Clinic> listClinic() {
        return (List<Clinic>) clinicRepository.findAll();
    }

//    @PostMapping
//    public @ResponseBody
//    Long createClinic(@RequestBody @Valid Long addressId) {
//
//        Address address = addressRestController.findAddress(addressId);
//
//        Clinic clinic = new Clinic();
//        clinic.setAddress(address);
//        clinicRepository.save(clinic);
//        return clinic.getId();
//    }


}


