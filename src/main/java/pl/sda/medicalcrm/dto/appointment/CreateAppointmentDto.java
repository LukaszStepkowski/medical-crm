package pl.sda.medicalcrm.dto.appointment;

import javax.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class CreateAppointmentDto {


    @Id
    private UUID id;

    @NotEmpty
    @NotBlank
    private LocalDateTime appointmentDate;

    @NotEmpty
    @NotBlank
    private boolean isOnline;

    public CreateAppointmentDto(UUID id, @NotEmpty @NotBlank LocalDateTime appointmentDate, @NotEmpty @NotBlank boolean isOnline) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.isOnline = isOnline;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public boolean isOnline() {
        return isOnline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAppointmentDto that = (CreateAppointmentDto) o;
        return isOnline == that.isOnline &&
                id.equals(that.id) &&
                appointmentDate.equals(that.appointmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, appointmentDate, isOnline);
    }
}
