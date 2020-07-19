package pl.sda.medicalcrm.dto;

import pl.sda.medicalcrm.entity.Examination;
import pl.sda.medicalcrm.entity.Patient;
import pl.sda.medicalcrm.entity.Specialization;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateAppointmentDto {

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

    public Appointment(LocalDateTime date, Patient patient, Specialization specialization,
                       String clinic, boolean isOnline, String prescription) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.patient = patient;
        this.specialization = specialization;
        this.examinations = new ArrayList<>();
        this.clinic = clinic;
        this.isOnline = isOnline;
        this.prescription = prescription;
    }
}
