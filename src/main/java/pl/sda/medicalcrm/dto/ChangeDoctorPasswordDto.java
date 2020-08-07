package pl.sda.medicalcrm.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class ChangeDoctorPasswordDto {

    @NotEmpty
    //minimum 8 characters and at least one Capital letter, one lower letter, one digit and one special character
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$")
    private String password;

    public ChangeDoctorPasswordDto(String password) {
        this.password = password;
    }

    public ChangeDoctorPasswordDto() {
    }

    public String getPassword() {
        return password;
    }
}
