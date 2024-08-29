package models;
import java.util.List;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Questions {

    @Getter
    @Setter
    @Id
    @UuidGenerator
    private String id;
    private String title;
    private Long creationDate;
    private Long lastUpdate;
    private String content;
    private Doctors author;
    private List<Responses> responses;


}
