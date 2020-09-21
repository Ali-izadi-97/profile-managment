package ir.science.city.profile.dto;

import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnUpdate;
import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class ProfileDto {

    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;

    private PersonalInformationDto personalInformationDto;
    private List<Long>  educationInformationsCode;
    private List<Long> teachingInformationsCode;

//    private SystemicRole role;
}
