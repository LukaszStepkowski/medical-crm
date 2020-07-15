
package pl.sda.medicalcrm.dto;

import com.sun.istack.NotNull;
import pl.sda.medicalcrm.entity.User;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

public final class CreateDoctorDto  {


    @NotEmpty
    @NotBlank
    @NotNull
    @Size(min=7, max=7)
    private String npwz;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String name;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String surname;
    @NotBlank
    @NotEmpty
    @Pattern(regexp = "[a-z]{6}")
    private String login;
    @NotEmpty
    //minimum 8 characters and at least one Capital letter, one lower letter, one digit and one special character
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;


    public CreateDoctorDto(String login, String password, String npwz, String name, String surname) {
        this.login=login;
        this.password=password;
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;

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

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDoctorDto that = (CreateDoctorDto) o;
        return npwz.equals(that.npwz) &&
                name.equals(that.name) &&
                surname.equals(that.surname) &&
                login.equals(that.login) &&
                password.equals(that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(npwz, name, surname, login, password);
    }
}

