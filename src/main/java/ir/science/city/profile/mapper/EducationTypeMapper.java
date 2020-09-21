package ir.science.city.profile.mapper;

import ir.science.city.profile.dto.EducationTypeDto;
import ir.science.city.profile.entity.EducationType;
import org.mapstruct.Mapper;

@Mapper
public interface EducationTypeMapper {
    EducationType toEntity(EducationTypeDto dto);
    EducationTypeDto toDto(EducationType entity);
}
