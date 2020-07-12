
package pl.sda.medicalcrm.dto;

import java.util.Objects;

public final class DoctorDto {

    private String npwz;
    private String name;
    private String surname;
    private String specialization;

    public DoctorDto(String npwz, String name, String surname, String specialization) {
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
        DoctorDto doctorDto = (DoctorDto) o;
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

