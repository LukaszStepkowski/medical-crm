package pl.sda.medicalcrm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "specializations")
public class Specialization {

    @Id
    private UUID id;

    String typeOfSpecialization;


    public Specialization( String typeOfSpecialization) {
        this.id =UUID.randomUUID();
        this.typeOfSpecialization = typeOfSpecialization;
    }

    public UUID getId() {
        return id;
    }

    public String getTypeOfSpecialization() {
        return typeOfSpecialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return typeOfSpecialization.equals(that.typeOfSpecialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfSpecialization);
    }
}
