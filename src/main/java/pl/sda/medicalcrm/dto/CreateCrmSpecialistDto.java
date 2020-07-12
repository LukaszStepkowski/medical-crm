package pl.sda.medicalcrm.dto;

import java.util.Objects;

public class CreateCrmSpecialistDto {

    private String login;
    private String password;
    private String name;
    private String surname;

    public CreateCrmSpecialistDto(String login, String password, String name, String surname) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateCrmSpecialistDto that = (CreateCrmSpecialistDto) o;
        return login.equals(that.login) &&
                password.equals(that.password) &&
                name.equals(that.name) &&
                surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, name, surname);
    }
}
