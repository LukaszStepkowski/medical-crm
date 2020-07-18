package pl.sda.medicalcrm.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "appointment")
public class Appointment {

    @Id
    private UUID id;
    private LocalDateTime date;
    private String patient;
    private String specialization;
    private List<String> examinations;
    private String clinic;
    private boolean isOnline;
    private String prescription;

    public Appointment(UUID id, LocalDateTime date, String patient, String specialization,
                       List<String> examinations, String clinic, boolean isOnline, String prescription) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.specialization = specialization;
        this.examinations = examinations;
        this.clinic = clinic;
        this.isOnline = isOnline;
        this.prescription = prescription;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getPatient() {
        return patient;
    }

    public String getSpecialization() {
        return specialization;
    }

    public List<String> getExaminations() {
        return examinations;
    }

    public String getClinic() {
        return clinic;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getPrescription() {
        return prescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return isOnline == that.isOnline &&
                id.equals(that.id) &&
                date.equals(that.date) &&
                patient.equals(that.patient) &&
                specialization.equals(that.specialization) &&
                examinations.equals(that.examinations) &&
                clinic.equals(that.clinic) &&
                prescription.equals(that.prescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, patient, specialization, examinations, clinic, isOnline, prescription);
    }
}
