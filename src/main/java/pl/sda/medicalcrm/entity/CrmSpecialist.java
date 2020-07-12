package pl.sda.medicalcrm.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@DiscriminatorValue("CRM_Specialist")
public class CrmSpecialist extends User {

    private String name;
    private String surname;

    private CrmSpecialist(){
    }

    public CrmSpecialist(String login, String password, String name, String surname) {
        super(login, password);
        this.name = name;
        this.surname = surname;
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
        if (!super.equals(o)) return false;
        CrmSpecialist that = (CrmSpecialist) o;
        return name.equals(that.name) &&
                surname.equals(that.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname);
    }
}
