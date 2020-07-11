package pl.sda.medicalcrm.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

import static pl.sda.medicalcrm.entity.util.Preconditions.requireNonNulls;


@Entity
@Table(name = "doctors")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "doctor_type")

public class Doctor {

    @Id
    @NotNull
    @Size(min=7, max=7)
    private String  npwz;
    @NotNull
    @NotEmpty
   // @Pattern(regexp = "[a-zA-z]")
    private String firstName;
    @NotEmpty
    @NotNull
    private String lastName;
    @NotEmpty
    @NotNull
    private String specialization;


    public Doctor(String npwz, String firstName, String lastName, String specialization) {
        requireNonNulls(npwz, firstName, lastName, specialization);
       // suepr(login, password);
        this.npwz = npwz;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
    }

    public String getNpwz() {
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



