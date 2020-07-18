package pl.sda.medicalcrm.entity;


import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    private UUID id;
    private LocalDateTime date;

    @OneToOne(cascade = CascadeType.ALL)
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    private Specialization specialization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Examination> examinations;

    private String clinic;
    private boolean isOnline;
    private String prescription;

    public Appointment() {
    }

    public Appointment(UUID id, LocalDateTime date, Patient patient, Specialization specialization,
                       String clinic, boolean isOnline, String prescription) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.specialization = specialization;
        this.examinations = new ArrayList<>();
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

    public Patient getPatient() {
        return patient;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void addExamination(Examination examination) {
        if (!examinations.contains(examination)){
            examinations.add(examination);
        }
    }

    public List<Examination> getExaminations() {
        return new ArrayList<>(examinations);
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
