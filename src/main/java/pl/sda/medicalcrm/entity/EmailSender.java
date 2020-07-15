package pl.sda.medicalcrm.entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class EmailSender {

    private String patientEmail;
    private String patientName;

    private EmailSender() {
    }

    public EmailSender(String patientEmail, String patientName) {
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
        EmailSender that = (EmailSender) o;
        return patientEmail.equals(that.patientEmail) &&
                patientName.equals(that.patientName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientEmail, patientName);
    }
}
