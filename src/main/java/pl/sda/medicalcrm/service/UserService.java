package pl.sda.medicalcrm.service;

import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.CreateAdminDto;
import pl.sda.medicalcrm.dto.CreateCrmSpecialistDto;
import pl.sda.medicalcrm.dto.CreateDoctorDto;
import pl.sda.medicalcrm.dto.CreatePatientDto;
import pl.sda.medicalcrm.entity.Admin;
import pl.sda.medicalcrm.entity.CrmSpecialist;
import pl.sda.medicalcrm.entity.Doctor;
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
                dto.getSurname(), dto.getPesel());
        repository.save(patient);
        return patient.getId();
    }

    @Transactional
    public UUID createCrmSpecialist(CreateCrmSpecialistDto dto) {
        var crmSpecialist = new CrmSpecialist(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname());
        repository.save(crmSpecialist);
        return crmSpecialist.getId();
    }
    @Transactional
    public UUID createDoctor(CreateDoctorDto dto) {
        var doctor =new Doctor(dto.getLogin(), dto.getPassword(),dto.getNpwz(), dto.getName(), dto.getSurname());
        repository.save(doctor);
        return doctor.getId();
    }


    @Transactional
    public void changeDoctorEntity(UUID userId, String login, String password,String npwz, String name, String surname){
        repository.updateDoctorEntity(userId, login,password,npwz, name, surname); }

    @Transactional
    public void changePatientEntity(UUID userId, String login, String password, String name, String surname, String pesel){
        repository.updatePatientEntity(userId,login,password,name,surname,pesel); }




    @Transactional
    public UUID createAdmin(CreateAdminDto dto) {
        var admin = new Admin(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname());
        repository.save(admin);
        return admin.getId();
    }
}
