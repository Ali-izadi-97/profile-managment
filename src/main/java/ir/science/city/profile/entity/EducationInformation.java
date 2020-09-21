package ir.science.city.profile.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@Table(name = "education_information")
public class EducationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "type_id")
    private EducationType type;

    private String name;

    private Long createdDate;
    private Long lastUpdate;

    public EducationInformation(String name, EducationType type) {
        this.name = name;
        this.type = type;
    }
}
