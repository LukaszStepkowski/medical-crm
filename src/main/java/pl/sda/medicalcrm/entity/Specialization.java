package pl.sda.medicalcrm.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "specializations")
public class Specialization {

    @Id
    private UUID id;

    private String typeOfSpecialization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<User> doctors;


    public Specialization() {
    }

    public Specialization(String typeOfSpecialization) {
        this.id =UUID.randomUUID();
        this.typeOfSpecialization = typeOfSpecialization;
        this.doctors = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public String getTypeOfSpecialization() {
        return typeOfSpecialization;
    }

    public void addDoctor(User user){
         if (!doctors.contains(user)){
             doctors.add(user);
         }
    }

    public List<User> getDoctors() {
        return doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Specialization that = (Specialization) o;
        return id.equals(that.id) &&
                typeOfSpecialization.equals(that.typeOfSpecialization) &&
                doctors.containsAll(that.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfSpecialization, doctors);
    }
}
