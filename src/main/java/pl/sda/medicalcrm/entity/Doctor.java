package pl.sda.medicalcrm.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@DiscriminatorValue("doctor")
public class Doctor extends User {


    private String npwz;
    private String name;
    private String surname;


    @OneToMany(cascade = CascadeType.ALL)
    private List<Specialization>specializations;

    public Doctor(){
    }


    public Doctor(String login, String password, String npwz, String name, String surname) {
        super(login, password);
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;
        this.specializations=new ArrayList<>();

    }

    public String getNpwz() { return npwz; }

    public String getName() { return name; }

    public String getSurname() { return surname; }

    public void addSpecialization(Specialization specialization){

        if(!specializations.contains(specialization)){
            specializations.add(specialization);
        }

    }

    public void removeSpecialization(UUID specializationId){
        specializations.stream()
                .filter(specialization -> specialization.getId().equals(specializationId))
                .findFirst()
                .ifPresent(specialization -> specializations.remove(specialization));
    }

    public List<Specialization> getSpecializations(){return  new ArrayList<>(specializations);}

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



