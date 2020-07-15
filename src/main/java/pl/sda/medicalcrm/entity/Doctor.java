package pl.sda.medicalcrm.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Objects;


@Entity
@DiscriminatorValue("doctor")
public class Doctor extends User {


    private String npwz;
    private String name;
    private String surname;

    public Doctor(){
    }


    public Doctor(String login, String password, String npwz, String name, String surname) {
        super(login, password);
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;

    }

    public String getNpwz() { return npwz; }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Doctor doctor = (Doctor) o;
        return npwz.equals(doctor.npwz) &&
                name.equals(doctor.name) &&
                surname.equals(doctor.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), npwz, name, surname);
    }
}



