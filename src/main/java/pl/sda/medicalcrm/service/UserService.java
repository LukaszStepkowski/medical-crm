package pl.sda.medicalcrm.service;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.*;
import pl.sda.medicalcrm.entity.*;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;
    public EmailService emailService;

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
        var doctor =new Doctor(dto.getLogin(), dto.getPassword(),dto.getNpwz(), dto.getName(), dto.getSurname(),dto.getSpecialization());
        repository.save(doctor);
        return doctor.getId();
    }

    @Transactional
    public UUID createAdmin(CreateAdminDto dto) {
        var admin = new Admin(dto.getLogin(), dto.getPassword(), dto.getName(), dto.getSurname());
        repository.save(admin);
        return admin.getId();
    }

    @Transactional
    public UUID createPatientWithSendingEmail(CreatePatientDto dto) throws MailjetSocketTimeoutException, MailjetException {
        var patient = new Patient(dto.getLogin(), dto.getPassword(), dto.getName(),
                dto.getSurname(), dto.getPesel());
        EmailSenderDto emailDto = new EmailSenderDto(dto.getLogin(), dto.getName());
        emailService.sendEmail(emailDto);
        repository.save(patient);
        return patient.getId();
    }


}
