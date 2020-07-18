package pl.sda.medicalcrm.service.specialization;

import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.repository.UserRepository;
import pl.sda.medicalcrm.service.UserMapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

public class SpecializationService {
    private final UserRepository repository;
    private final UserMapper mapper;

    public SpecializationService(UserRepository repository, UserMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


  @Transactional
    public void createSpecialization (UUID userId, String ){
        var specialization =
  }

  public List<SpecializationDto> listSpecialization(UUID doctorId){
        var doctor = repository.getOne(doctorId);
        return mapper.mapSpecialization(doctor.getSpecialization));
  }

}
