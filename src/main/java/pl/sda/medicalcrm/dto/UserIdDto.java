package pl.sda.medicalcrm.dto;

import java.util.UUID;

public class UserIdDto {

    private UUID id;

    public UserIdDto(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
