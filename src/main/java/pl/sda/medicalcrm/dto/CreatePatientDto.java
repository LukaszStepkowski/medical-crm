package pl.sda.medicalcrm.dto;

import java.util.Objects;

public class CreatePatientDto {

    private String login;
    private String password;
    private String name;
    private String surname;
    private String pesel;

    public CreatePatientDto(String login, String password, String name, String surname, String pesel) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
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

    public String getPesel() {
        return pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreatePatientDto that = (CreatePatientDto) o;
        return login.equals(that.login) &&
                password.equals(that.password) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                pesel.equals(that.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, name, surname, pesel);
    }
}
