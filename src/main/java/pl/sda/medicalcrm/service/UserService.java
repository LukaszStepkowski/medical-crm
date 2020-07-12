package pl.sda.medicalcrm.service;

import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.CreateCrmSpecialistDto;
import pl.sda.medicalcrm.dto.CreatePatientDto;
import pl.sda.medicalcrm.entity.CrmSpecialist;
import pl.sda.medicalcrm.entity.Patient;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService (UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UUID createPatient(CreatePatientDto dto) {
        var patient = new Patient(dto.getLogin(), dto.getPassword(), dto.getName(),
                dto.getSurname(), Integer.valueOf(dto.getPesel()));
        repository.save(patient);
        return patient.getId();
    }

    public UUID createCrmSpecialist(CreateCrmSpecialistDto dto) {
        var crmSpecialist = new CrmSpecialist(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname());
        repository.save(crmSpecialist);
        return crmSpecialist.getId();
    }
}
