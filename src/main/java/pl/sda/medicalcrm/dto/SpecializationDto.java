package pl.sda.medicalcrm.dto;

import pl.sda.medicalcrm.entity.Specialization;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class SpecializationDto {

    @Id
    private UUID id;
    @NotEmpty
    @NotBlank

    String typeOfSpecialization;

    public SpecializationDto(UUID id, String typeOfSpecialization) {
        this.id = id;
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
        SpecializationDto that = (SpecializationDto) o;
        return Objects.equals(typeOfSpecialization, that.typeOfSpecialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(typeOfSpecialization);
    }
}
