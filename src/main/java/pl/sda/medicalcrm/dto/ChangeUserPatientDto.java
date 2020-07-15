package pl.sda.medicalcrm.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ChangeUserPatientDto {
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

    public ChangeUserPatientDto( String login, String password,  String name, String surname, String pesel) {
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
}
