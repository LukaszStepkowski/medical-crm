
package pl.sda.medicalcrm.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public final class CreateDoctorDto {


    @NotEmpty
    @NotBlank
    private String npwz;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String name;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String surname;
    @NotEmpty
    @NotBlank
    @Pattern(regexp = "\\w[a-zA-Z]{1,}")
    private String specialization;

    public CreateDoctorDto(String npwz, String name, String surname, String specialization) {
        this.npwz = npwz;
        this.name = name;
        this.surname = surname;
        this.specialization = specialization;
    }

    public String getNpwz() {
        return npwz;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateDoctorDto doctorDto = (CreateDoctorDto) o;
        return npwz.equals(doctorDto.npwz) &&
                name.equals(doctorDto.name) &&
                surname.equals(doctorDto.surname) &&
                specialization.equals(doctorDto.specialization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(npwz, name, surname, specialization);
    }
}

