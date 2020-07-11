package pl.sda.medicalcrm.entity;

import javax.persistence.*;
import java.util.Objects;

import static pl.sda.medicalcrm.util.Preconditions.requireNonNulls;

@Entity
@Table(name = "doctors")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "doctor_type")

public class Doctor {

    @Id
    private int npwz;
    private String firstName;
    private String lastName;
    private String specialization;


    public Doctor(int npwz, String firstName, String lastName, String specialization) {
        requireNonNulls(npwz, firstName, lastName, specialization);
        this.npwz = npwz;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public int getNpwz() {
        return npwz;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return npwz == doctor.npwz &&
                firstName.equals(doctor.firstName) &&
                lastName.equals(doctor.lastName) &&
                specialization.equals(doctor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(npwz, firstName, lastName, specialization);
    }
}
