package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.Admin;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    private boolean isLoginAlreadyInDataBase(User user) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()));
    }

    @Transactional
    public Long registerNewAdmin (Admin admin) {
        if (isLoginAlreadyInDataBase(admin)) return 0L;
        userRepository.save(admin);
        return admin.getId();
    }

    @Transactional
    public Long changeAdminData(Long id, Admin admin){
        if (!userRepository.findById(id).isPresent()) return 0L;
        admin.setId(id);
        userRepository.save(admin);
        return admin.getId();
    }
}
