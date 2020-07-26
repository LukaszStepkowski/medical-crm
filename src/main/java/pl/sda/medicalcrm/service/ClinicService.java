package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.sda.medicalcrm.entity.Address;
import pl.sda.medicalcrm.entity.Clinic;
import pl.sda.medicalcrm.repository.ClinicRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public List<Clinic> getAllClinicsList(){
        return (List<Clinic>) clinicRepository.findAll();
    }

    @Transactional
    public Long createNewClinic(Address address){
        if (isClinicAlreadyInDataBase(address)) return 0L;
        Clinic clinic = new Clinic();
        clinic.setAddress(address);
        clinicRepository.save(clinic);
        return clinic.getId();
    }

    private boolean isClinicAlreadyInDataBase(Address address){
        List<Clinic> clinics = getAllClinicsList();
        return clinics.stream().anyMatch(c -> c.getAddress().getStreet().equals(address.getStreet())
                && c.getAddress().getCity().equals(address.getCity()));
    }
}
