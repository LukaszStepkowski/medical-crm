package pl.sda.medicalcrm.service;

import pl.sda.medicalcrm.dto.SpecializationDto;
import pl.sda.medicalcrm.dto.UserQueryResultDto;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.Specialization;
import pl.sda.medicalcrm.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;


public class UserMapper {


    List<SpecializationDto> mapSpecialization(List<Specialization> specializations) {

        return specializations.stream()
                .map(specialization -> new SpecializationDto(specialization.getId(),
                        specialization.getType(), specialization.getName(), specialization.getSurname()))
                .collect(toList());
    }


    public UserQueryResultDto map(User user) {
        return new UserQueryResultDto(

                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user instanceof Doctor
                        ? UserQueryResultDto.UserType.DOCTOR
                        : UserQueryResultDto.UserType.PATIENT
        );
    }
}
