package ir.science.city.profile.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Accessors(chain = true)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "personal_information")
public class PersonalInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name = "last_name")
    @NotNull @NotBlank
    private String lastName;

    @Column(name = "national_code", unique = true)
    @NotNull @NotBlank
    private String nationalCode;

    @Column(name = "main_phone")
    private String mainPhone;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "personal_information_contact",
            joinColumns = @JoinColumn(name = "personal_information_id"),
            inverseJoinColumns = @JoinColumn(name = "contact_id")
    )
    private List<Contact> contacts = new ArrayList<>();
    private String address;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birth_date")
    private Long birthDate;

    @Column(name = "marital")
    private Marital marital;

    @Column(name = "photo")
    private String photo;

    private Long createdDate;
    private Long lastUpdate;

    public void addContact(Contact contact) {
        this.contacts.add(contact);
    }
}
