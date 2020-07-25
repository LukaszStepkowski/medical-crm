package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private UserRepository userRepository;

    private boolean isLoginAlreadyInDataBase(User user) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()));
    }

    @Transactional
    public Long registerNewDoctor (Doctor doctor) {
        if (isLoginAlreadyInDataBase(doctor)) return 0L;
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
}
