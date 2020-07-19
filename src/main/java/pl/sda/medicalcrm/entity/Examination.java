package pl.sda.medicalcrm.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "examinations")

public class Examination {

    @Id
    private UUID id;
    private String type;
    private String result;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Picture> picturePath;
    private String description;

    public Examination() {
    }

    public Examination(String type, String result, String description) {
        this.id = UUID.randomUUID();
        this.type = type;
        this.result = result;
        this.picturePath = new ArrayList<>();
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getResult() {
        return result;
    }

    public void addPicture(Picture picture) {
        if (!picturePath.contains(picture)){
            picturePath.add(picture);
        }
    }

    public List<Picture> getPicturePath() {
        return new ArrayList<>(picturePath);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examination that = (Examination) o;
        return id.equals(that.id) &&
                type.equals(that.type) &&
                result.equals(that.result) &&
                Objects.equals(picturePath, that.picturePath) &&
                description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, result, picturePath, description);
    }
}




