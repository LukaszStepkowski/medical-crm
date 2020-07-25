package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.repository.AddressRepository;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public AddressService() {
    }

    public List<Address> getListOfAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }


    public Long createAddress(Address address) {
        if (checkForAddress(address)) return 0L;

        addressRepository.save(address);
        return address.getId();
    }

//    @GetMapping(path = "/addresses/{addressId}")
//    public @ResponseBody
//    Address findAddress(@PathVariable Long addressId) {
//        Optional<Address> addressOptional = addressRepository.findById(addressId);
//        return addressOptional.get();
//    }


    private boolean checkForAddress(Address address) {
        return getListOfAllAddresses().stream()
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
