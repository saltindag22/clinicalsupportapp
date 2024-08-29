package models;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Responses {

    @Getter
    @Setter
    @Id
    @UuidGenerator
    private Long id;
    private String content;
    private String author;
    private LocalDateTime creationDate;
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Questions question;

}
