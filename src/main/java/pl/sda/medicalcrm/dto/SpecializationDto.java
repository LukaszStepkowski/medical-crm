package pl.sda.medicalcrm.dto;

import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

public class SpecializationDto {

    @Id
    private UUID id;
    String type;
    String name;
    String surname;

    public SpecializationDto(UUID id, String type, String name, String surname) {
        this.id = id;
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
        SpecializationDto that = (SpecializationDto) o;
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
