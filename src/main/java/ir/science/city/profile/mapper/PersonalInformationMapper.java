package ir.science.city.profile.mapper;

import ir.science.city.profile.dto.PersonalInformationDto;
import ir.science.city.profile.entity.PersonalInformation;
import org.mapstruct.Mapper;

@Mapper
public interface PersonalInformationMapper {
    PersonalInformation toEntity(PersonalInformationDto dto);
    PersonalInformationDto toDto(PersonalInformation entity);
}
