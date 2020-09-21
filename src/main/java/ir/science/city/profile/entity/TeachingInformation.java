package ir.science.city.profile.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "teaching_information")
public class TeachingInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private EducationType type;

    private String name;

    private Member member;
    private Long createdDate;
    private Long lastUpdate;

    public TeachingInformation(String name, EducationType type, Member member) {
        this.name = name;
        this.type = type;
        this.member = member;
    }
}
