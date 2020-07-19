package pl.sda.medicalcrm.service.specialization;

import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.SpecializationRepository;
import pl.sda.medicalcrm.repository.UserRepository;
import pl.sda.medicalcrm.service.UserMapper;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SpecializationService {
    private final SpecializationRepository specializationRepository;
    private final SpecializationMapper specializationMapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public SpecializationService(SpecializationRepository repository, SpecializationMapper mapper, UserRepository userRepository, UserMapper userMapper) {
        this.specializationRepository = repository;
        this.specializationMapper = mapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public Specialization createSpecialization(String typeOfSpecialization) {
        var specialization = new Specialization(typeOfSpecialization);
        return specializationRepository.save(specialization);
    }

    public List<SpecializationDto> listSpecialization() {
        return specializationMapper.mapSpecialization(specializationRepository.findAll());
    }


    @Transactional
    public void connectSpecializationDoctor(UUID userId, UUID specializationId) {
        specializationRepository.findById(specializationId).ifPresent(specialization -> userRepository.findById(userId)
                .ifPresent(user -> addDoctorToSpecialization(specialization,  user)));
    }

    @Transactional
    private void addDoctorToSpecialization(Specialization specialization, User user) {


        specialization.addDoctor(user);
        specializationRepository.save(specialization);
    }
}
