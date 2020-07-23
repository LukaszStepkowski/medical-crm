package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.repository.AddressRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/addresses")
public class AddressRestController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> listAddresses(){
        return (List<Address>) addressRepository.findAll();
    }

    @PostMapping
    public @ResponseBody
    Long createAddress(@RequestBody @Valid Address address) {
        addressRepository.save(address);
        return address.getId();
    }
}


