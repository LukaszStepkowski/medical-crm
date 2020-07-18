package pl.sda.medicalcrm.dto;

import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

public class SpecializationDto {

    @Id
    private UUID id;
    String typeOfSpecialization;

    public SpecializationDto(UUID id, String typeSpecialization) {
        this.id = id;
        this.typeOfSpecialization = typeSpecialization;
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
        SpecializationDto that = (SpecializationDto) o;
        return id.equals(that.id) &&
                typeOfSpecialization.equals(that.typeOfSpecialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeOfSpecialization);
    }
}
