package pl.sda.medicalcrm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.entity.Admin;
import pl.sda.medicalcrm.entity.CrmSpecialist;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CrmSpecialistService {

    @Autowired
    private UserRepository userRepository;

    private boolean isLoginAlreadyInDataBase(User user) {
        List<User> allUsers = (List<User>) userRepository.findAll();
        return allUsers.stream().anyMatch(u -> u.getLogin().equals(user.getLogin()));
    }

    @Transactional
    public Long registerNewCrmSpecialist(CrmSpecialist crmSpecialist) {
        if (isLoginAlreadyInDataBase(crmSpecialist)) return 0L;
        userRepository.save(crmSpecialist);
        return crmSpecialist.getId();
    }

    @Transactional
    public Long changeCrmSpecialistData(Long id, CrmSpecialist crmSpecialist){
        if (!userRepository.findById(id).isPresent()) return 0L;
        crmSpecialist.setId(id);
        userRepository.save(crmSpecialist);
        return crmSpecialist.getId();
    }
}
