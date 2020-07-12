package pl.sda.medicalcrm.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class CreateCrmSpecialistDto {

    @NotBlank
    @NotEmpty
    @Pattern(regexp = "[a-z]{6}")
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
