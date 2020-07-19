package pl.sda.medicalcrm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="clinics")
public class Clinic {

    @Id
    private UUID id;
    @OneToOne(cascade = CascadeType.ALL)
    private Address addresses;


    public Clinic() {
    }

    public Clinic(Address addresses) {
        this.id = UUID.randomUUID();
        this.addresses = addresses;
    }

    public UUID getId() {
        return id;
    }

    public Address getAddresses() {
        return addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clinic clinic = (Clinic) o;
        return id.equals(clinic.id) &&
                addresses.equals(clinic.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, addresses);
    }
}
