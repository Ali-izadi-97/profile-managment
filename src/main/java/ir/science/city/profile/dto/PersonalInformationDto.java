package ir.science.city.profile.dto;

import ir.science.city.profile.entity.Gender;
import ir.science.city.profile.entity.Marital;
import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnUpdate;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class PersonalInformationDto {
    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;
    @NotNull
    @NotBlank
    private String firstName;

    @NotNull @NotBlank
    private String lastName;

    @NotNull @NotBlank
    private String nationalCode;

    private String mainPhone;
    private String address;

    private Gender gender;
    private Long birthDate;
    private Marital marital;
    private String photo;

}
