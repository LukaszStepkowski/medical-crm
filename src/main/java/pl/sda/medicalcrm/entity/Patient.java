package pl.sda.medicalcrm.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("patient")
public class Patient extends User {

    private String name;
    private String surname;
    private String pesel;

    private Patient(){
    }

    public Patient(String login, String password, String name, String surname, String pesel) {
        super(login, password);
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
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
