package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.ClinicRepository;

import java.util.List;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    public ClinicService() {
    }

    public List<Clinic> getListOfAllClinics() {
        return (List<Clinic>) clinicRepository.findAll();
    }

    public Long createClinic(Clinic clinic) {
        if (doesClinicExists(clinic)) return 0L;

        clinicRepository.save(clinic);
        return clinic.getId();
    }

    public boolean doesClinicExists(Clinic clinic) {
        return getListOfAllClinics().stream()
                .anyMatch(s -> s.getClinicName().equals(clinic.getClinicName())
                );
    }

    public Long saveClinic(Clinic clinic) {
        clinicRepository.save(clinic);
        return clinic.getId();
    }


}



