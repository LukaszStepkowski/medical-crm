package pl.sda.medicalcrm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime appointmentDate;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Specialization specialization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Examination> examinations;

    @OneToOne(cascade = CascadeType.ALL)
    private Clinic clinic;

    private boolean isOnline;

    @OneToOne(cascade = CascadeType.ALL)
    private Prescription prescription;

}