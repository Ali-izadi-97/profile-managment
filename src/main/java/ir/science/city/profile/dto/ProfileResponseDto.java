package ir.science.city.profile.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
public class ProfileResponseDto {
    private Long id;
    private PersonalInformationDto personal;
    private List<EducationInformationDto> educations;
    private List<TeachingInformationDto> teachs;
}
