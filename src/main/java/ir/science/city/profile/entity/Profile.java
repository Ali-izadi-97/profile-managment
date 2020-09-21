package ir.science.city.profile.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "profile")
public class Profile {

    @Id
    @GeneratedValue
    private Long id;


    @OneToOne
    private PersonalInformation personalInformation;

    @OneToMany
    @JoinTable(
            name = "education_information_profile",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "education_information_id")
    )

    private List<EducationInformation> educationInformations = new ArrayList<>();


    @OneToMany
    @JoinTable(
            name = "teaching_information_profile",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "teaching_information_id")
    )
    private List<TeachingInformation> teachingInformations = new ArrayList<>();

    @OneToOne
    private SystemicRole systemicRole;

    public void addEducationInformation(EducationInformation edu) {
        this.educationInformations.add(edu);
    }

    public void addTeachingInformation(TeachingInformation th) {
        this.teachingInformations.add(th);
    }
}


