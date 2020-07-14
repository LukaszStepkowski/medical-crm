package pl.sda.medicalcrm.entity;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class EmailSender {

    private String patientEmail;
    private String patientName;
    private String emailTitle;
    private String emailHeader;
    private String emailText;

    private EmailSender() {
    }

    public EmailSender(String patientEmail, String patientName, String emailTitle, String emailHeader, String emailText) {
        this.patientEmail = patientEmail;
        this.patientName = patientName;
        this.emailTitle = emailTitle;
        this.emailHeader = emailHeader;
        this.emailText = emailText;
    }


    public String getPatientEmail() {
        return patientEmail;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getEmailTitle() {
        return emailTitle;
    }

    public String getEmailHeader() {
        return emailHeader;
    }

    public String getEmailText() {
        return emailText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailSender that = (EmailSender) o;
        return patientEmail.equals(that.patientEmail) &&
                patientName.equals(that.patientName) &&
                emailTitle.equals(that.emailTitle) &&
                emailHeader.equals(that.emailHeader) &&
                emailText.equals(that.emailText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientEmail, patientName, emailTitle, emailHeader, emailText);
    }
}
