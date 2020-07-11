package pl.sda.medicalcrm.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;

import static pl.sda.medicalcrm.entity.util.Preconditions.requireNonNulls;

@Entity
@DiscriminatorValue("doctor")
public class Doctor extends User {

    @NotNull
    @Size(min=7, max=7)
    private String npwz;
    @NotNull
    @NotEmpty
   // @Pattern(regexp = "[a-zA-z]")
    private String name;
    @NotEmpty
    @NotNull
    private String surname;
    @NotEmpty
    @NotNull
    private String specialization;

    private Doctor(){
    }


    public Doctor(String login, String password, String npwz, String name, String surname, String specialization) {
        super(login, password);
        requireNonNulls(npwz, name, surname, specialization);
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public String getNpwz() {
        return npwz;
    }

    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return npwz.equals(doctor.npwz) &&
                name.equals(doctor.name) &&
                surname.equals(doctor.surname) &&
                specialization.equals(doctor.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), npwz, name, surname, specialization);
    }
}



