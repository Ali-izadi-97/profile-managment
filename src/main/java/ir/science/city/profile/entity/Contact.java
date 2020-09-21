package ir.science.city.profile.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
@Table(name = "contact")
public class Contact{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    ContactType type;
    String content;

    private Long createdDate;
    private Long lastUpdate;
}
