package pl.sda.medicalcrm.service.specialization;

import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.repository.SpecializationRepository;


import javax.transaction.Transactional;
import java.util.List;

public class SpecializationService {
    private final SpecializationRepository repository;
    private final SpecializationMapper mapper;

    public SpecializationService(SpecializationRepository repository, SpecializationMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public Specialization createSpecialization (String typeOfSpecialization){
        var specialization = new Specialization(typeOfSpecialization);
        return repository.save(specialization);
  }

  public List<SpecializationDto> listSpecialization(){
        return mapper.mapSpecialization(repository.findAll());
  }

}
