package pl.sda.medicalcrm.dto;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public class EmailSenderDto {

    @Email
    private String patientEmail;

    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String patientName;


    public EmailSenderDto(String patientEmail, String patientName) {
        this.patientEmail = patientEmail;
        this.patientName = patientName;

    }

    public String getPatientEmail() {
        return patientEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailSenderDto that = (EmailSenderDto) o;
        return patientEmail.equals(that.patientEmail) &&
                patientName.equals(that.patientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientEmail, patientName);
    }
}

















