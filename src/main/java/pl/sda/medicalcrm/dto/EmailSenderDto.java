package pl.sda.medicalcrm.dto;

import java.util.Objects;

public class EmailSenderDto {

    public String patientEmail;
    public String patientName;

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


