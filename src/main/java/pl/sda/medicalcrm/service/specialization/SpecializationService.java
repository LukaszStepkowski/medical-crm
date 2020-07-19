package pl.sda.medicalcrm.service.specialization;

import org.springframework.stereotype.Service;
import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.entity.User;
import pl.sda.medicalcrm.repository.SpecializationRepository;
import pl.sda.medicalcrm.repository.UserRepository;
import pl.sda.medicalcrm.service.UserMapper;


import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class SpecializationService {
    private final SpecializationRepository repository;
    private final SpecializationMapper mapper;
    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public SpecializationService(SpecializationRepository repository, SpecializationMapper mapper, UserRepository userRepository, UserMapper userMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public SpecializationService(SpecializationRepository repository, SpecializationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public Specialization createSpecialization(String typeOfSpecialization) {
        var specialization = new Specialization(typeOfSpecialization);
        return repository.save(specialization);
    }

    public List<SpecializationDto> listSpecialization() {
        return mapper.mapSpecialization(repository.findAll());
    }





    @Transactional
    public void connectSpecializationDoctor(UUID doctorId, UUID specializationId ) {
        Specialization specialization = repository.getOne(specializationId);
        Doctor doctor = (Doctor) UserRepository.;
        specialization.
        UserRepository.save(doctor);

    }


   /* public List<SpecializationDto> listSpecialization(UUID doctorId) {
        var doctor = repository.getOne(doctorId);
        return mapper.mapSpecialization(doctor.getTypeOfSpecialization());
    }*/


}
