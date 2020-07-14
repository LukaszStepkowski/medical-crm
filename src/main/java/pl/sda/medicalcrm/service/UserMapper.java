package pl.sda.medicalcrm.service;

import org.springframework.stereotype.Component;
import pl.sda.medicalcrm.dto.UserQueryResultDto;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.User;

import java.lang.annotation.Documented;
import java.util.List;

@Component
public class UserMapper {


    private UserQueryResultDto map(User user) {
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
