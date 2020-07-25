package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Long registerNewPatient (Patient patient) {
        if (isLoginAlreadyInDataBase(patient)) return 0L;
        userRepository.save(patient);
        return patient.getId();
    }

    @Transactional
    public Long changePatientData(Long id, Patient patient){
        if (!userRepository.findById(id).isPresent()) return 0L;
        patient.setId(id);
        userRepository.save(patient);
        return patient.getId();
    }

    private boolean isLoginAlreadyInDataBase(User user) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()));
    }
//
//    @Transactional
//    public UUID createCrmSpecialist(CreateCrmSpecialistDto dto) {
//        var crmSpecialist = new CrmSpecialist(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname());
//        repository.save(crmSpecialist);
//        return crmSpecialist.getId();
//    }
//    @Transactional
//    public UUID createDoctor(CreateDoctorDto dto) {
//        var doctor =new Doctor(dto.getLogin(), dto.getPassword(),dto.getNpwz(), dto.getName(), dto.getSurname());
//        repository.save(doctor);
//        return doctor.getId();
//    }
//
//    @Transactional
//    public void changeDoctorEntity(UUID userId, String login, String password,String npwz, String name, String surname){
//        repository.updateDoctorEntity(userId, login,password,npwz, name, surname); }
//
//    @Transactional
//    public void changePatientEntity(UUID userId, String login, String password, String name, String surname, String pesel){
//        repository.updatePatientEntity(userId,login,password,name,surname,pesel); }
//
//    @Transactional
//    public UUID createAdmin(CreateAdminDto dto) {
//        var admin = new Admin(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname());
//        repository.save(admin);
//        return admin.getId();
//    }
//
//    @Transactional
//    public void changePatientPassword(UUID userId, String password){
//        repository.updatePatientPassword(userId,password);
//    }
//
//    @Transactional
//    public void changeDoctorPassword(UUID userId, String password){
//        repository.updateDoctorPassword(userId,password);
//    }
//
//    @Transactional
//    public void changeCrmSpecialistPassword(UUID userId, String password){
//        repository.updateCrmSpecialistPassword(userId,password);
//    }

}
