package pl.sda.medicalcrm.dto;

import org.hibernate.validator.constraints.pl.PESEL;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class CreatePatientDto {

    @Email
    private String login;

    @NotEmpty
    //minimum 8 characters and at least one Capital letter, one lower letter, one digit and one special character
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String name;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z\\-]{1,}")
    private String surname;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\d{11}")
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
