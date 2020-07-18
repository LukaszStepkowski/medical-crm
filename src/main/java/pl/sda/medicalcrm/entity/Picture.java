package pl.sda.medicalcrm.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    private UUID id;
    private String picturePath;

    public Picture() {
    }

    public Picture(UUID id, String picturePath) {
        this.id = id;
        this.picturePath = picturePath;
    }

    public UUID getId() {
        return id;
    }

    public String getPicturePath() {
        return picturePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Picture picture = (Picture) o;
        return id.equals(picture.id) &&
                picturePath.equals(picture.picturePath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, picturePath);
    }
}