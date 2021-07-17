package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.enums.TypeOfUser;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorService {

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private UserRepository userRepository;

    private boolean isLoginAlreadyInDataBase(User user) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers.stream().anyMatch(u -> u.getUsername().equals(user.getUsername()));
    }

    @Transactional
    public Long registerNewDoctor (Doctor doctor) {
        if (isLoginAlreadyInDataBase(doctor)) return 0L;
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        userRepository.save(doctor);
        return doctor.getId();
    }

    @Transactional
    public Long changeDoctorData(Long id, Doctor doctor){
        if (!userRepository.findById(id).isPresent()) return 0L;
        doctor.setId(id);
        userRepository.save(doctor);
        return doctor.getId();
    }

    public List<User> getAllDoctorsList() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream().filter(u -> u.getTypeOfUser().equals(TypeOfUser.DOCTOR)).collect(Collectors.toList());
    }
}
