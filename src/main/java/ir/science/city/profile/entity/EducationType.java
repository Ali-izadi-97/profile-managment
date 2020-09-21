package ir.science.city.profile.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "education_type")
@Accessors(chain = true)
public class EducationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Long createdDate;
    private Long lastUpdate;

    public EducationType(String name) {
        this.name = name;
    }
}
