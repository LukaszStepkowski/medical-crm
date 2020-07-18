package pl.sda.medicalcrm.service.specialization;

import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.entity.Specialization;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class SpecializationMapper {



    List<SpecializationDto> mapSpecialization(List<Specialization> specializations) {

        return specializations.stream()
                .map(specialization -> new SpecializationDto(specialization.getId(),
                        specialization.getTypeOfSpecialization()))
                .collect(toList());
    }
}
