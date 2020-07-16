package pl.sda.medicalcrm.service;

import org.springframework.stereotype.Component;
import pl.sda.medicalcrm.dto.UserQueryResultDto;
import pl.sda.medicalcrm.entity.Doctor;
import pl.sda.medicalcrm.entity.User;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;


public class UserMapper {


    List<UserQueryResultDto>map(List<User> users) {

        List<UserQueryResultDto> list = new ArrayList<>();
        for (User user : users) {
            UserQueryResultDto map = map(user);
            list.add(map);
        }
        return list;
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
