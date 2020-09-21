package ir.science.city.profile.mapper;

import ir.science.city.profile.dto.EducationInformationDto;
import ir.science.city.profile.entity.EducationInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EducationInformationMapper {
//    EducationInformation toEntity(EducationInformationDto dto);

    @Mappings({
            @Mapping(target = "name", source = "name"),
            @Mapping(target = "type", source = "type.name"),
            @Mapping(target = "id", source = "id")
    })
    EducationInformationDto toDto(EducationInformation entity);
}
