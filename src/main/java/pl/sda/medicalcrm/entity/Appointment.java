package pl.sda.medicalcrm.entity;

import jdk.jfr.BooleanFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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

    @DateTimeFormat
    private LocalDateTime appointmentDate;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    private Specialization specialization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Examination> examinations;

    @OneToOne(cascade = CascadeType.ALL)
    private Clinic clinic;

    @BooleanFlag
    private boolean isOnline;

    @OneToOne(cascade = CascadeType.ALL)
    private Prescription prescription;

}