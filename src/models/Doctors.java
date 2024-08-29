package models;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Doctors {

    @Getter
    @Setter
    @Id
    @UuidGenerator
    private String id;
    private String password;
    private String name;
    private String profession;
    private String workPlace;
    private String gradSchool;

    public Doctors(String id, String password, String name){
        this.id = id;
        this.password = password;
        this.name= name;
    }
}
