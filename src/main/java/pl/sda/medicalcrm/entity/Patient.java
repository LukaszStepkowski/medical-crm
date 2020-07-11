package pl.sda.medicalcrm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("patient")
@NoArgsConstructor
@Getter
public class Patient extends User {

        private String name;
        private String surname;
        private int pesel;

    public Patient(String name, String surname, int pesel) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return pesel == patient.pesel &&
                name.equals(patient.name) &&
                surname.equals(patient.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, pesel);
    }
}
