package ir.science.city.profile.dto;

import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnUpdate;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EducationInformationDto {
    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    private Long id;
    private String type;
    private String name;
}
