package pl.sda.medicalcrm.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangeUserDoctorDto {
    @NotNull
    @NotBlank
    private String login;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String npwz;
    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    private String surname;
    @NotNull
    @NotBlank
    private String specialization;

    public ChangeUserDoctorDto(String login, String password, String npwz, String name, String surname, String specialization) {
        this.login = login;
        this.password = password;
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    ChangeUserDoctorDto(){}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNpwz() {
        return npwz;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialization() {
        return specialization;
    }

}
