package pl.sda.medicalcrm.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity
@DiscriminatorValue("specialization")
public class Specialization {

    @Id
    private UUID id;
    String type;
    String name;
    String surname;


    private Specialization(){}


    public Specialization(String type, String name, String surname) {
        this.id =UUID.randomUUID();
        this.type = type;
        this.name = name;
        this.surname = surname;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return id.equals(that.id) &&
                type.equals(that.type) &&
                name.equals(that.name) &&
                surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, surname);
    }
}
