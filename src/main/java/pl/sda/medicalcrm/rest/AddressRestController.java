package pl.sda.medicalcrm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.repository.AddressRepository;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/addresses")
public class AddressRestController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping
    public List<Address> listAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    @PostMapping
    public @ResponseBody
    Long createAddress(@RequestBody @Valid Address address) {
        if (checkForAddress(address)) {
            return 0L;
        } else {
            addressRepository.save(address);
        }
        return address.getId();
    }

    @GetMapping(path = "/addresses/{addressId}")
    public Address findAddress(Long addressId) {
        Optional<Address> addressOptional = addressRepository.findById(addressId);
        return addressOptional.get();
    }


    private boolean checkForAddress(Address address) {
        return listAddresses().stream()
                .anyMatch(s -> s.getCity().equals(address.getCity())
                        && s.getCountry().equals(address.getCountry())
                        && s.getStreet().equals((address.getStreet()))
                        && s.getZipCode().equals(address.getZipCode())
                );
    }
//
//    protected boolean checkForAddressById(Long addressId) {
//        return listAddresses().stream()
//                .anyMatch(s -> s.getId().equals(addressId)
//                );
//    }

}


