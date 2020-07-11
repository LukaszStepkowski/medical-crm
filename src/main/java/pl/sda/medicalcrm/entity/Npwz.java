package pl.sda.medicalcrm.entity;

import javax.persistence.Column;

import java.util.Objects;

import static pl.sda.medicalcrm.util.Preconditions.requireNonNulls;

public class Npwz {

    @Column(name = "NPWZ")
    private String value;

    public Npwz(String value) {
        requireNonNulls(value);
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (!value.matches("\\d{7}")) {
            throw new IllegalArgumentException("NPWZ is invalid: " + value);
        }
    }


    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Npwz npwz = (Npwz) o;
        return value.equals(npwz.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
