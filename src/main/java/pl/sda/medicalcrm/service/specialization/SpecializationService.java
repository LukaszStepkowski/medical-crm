package pl.sda.medicalcrm.service.specialization;

import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.repository.SpecializationRepository;


import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public class SpecializationService {
    private final SpecializationRepository repository;
    private final SpecializationMapper mapper;

    public SpecializationService(SpecializationRepository repository, SpecializationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public void createSpecialization (UUID userId, String typeOfSpecialization ){
        var specialization = 
                var doctor
  }

  public List<SpecializationDto> listSpecialization(UUID doctorId){
        var doctor = repository.getOne(doctorId);
        return mapper.mapSpecialization(doctor.getTypeOfSpecialization());
  }

}
