package pl.sda.medicalcrm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name="prescriptions")
public class Prescription {

    @Id
    private UUID id;
    int prescriptionNo;
    String description;

    public Prescription() {
    }

    public Prescription(int prescriptionNo, String description) {
        this.id = UUID.randomUUID();
        this.prescriptionNo = prescriptionNo;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public int getPrescriptionNo() {
        return prescriptionNo;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return prescriptionNo == that.prescriptionNo &&
                id.equals(that.id) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prescriptionNo, description);
    }
}
