package pl.sda.medicalcrm.dto;

import java.util.Objects;
import java.util.UUID;

public class UserQueryResultDto {

    public UserQueryResultDto(UUID id, String login, String password, UserType userType) {
    }

    public enum UserType{

        PATIENT, DOCTOR;
    }


    private UserType type;
    private String login;
    private String password;
    private String npwz;
    private String name;
    private String surname;
    private String pesel;


    public UserQueryResultDto(UserType type, String login, String password, String npwz, String name, String surname, String pesel) {
        this.type = type;
        this.login = login;
        this.password = password;
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public UserType getType() {
        return type;
    }

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

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserQueryResultDto that = (UserQueryResultDto) o;
        return type == that.type &&
                login.equals(that.login) &&
                password.equals(that.password) &&
                npwz.equals(that.npwz) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                pesel.equals(that.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, login, password, npwz, name, surname, pesel);
    }
}
