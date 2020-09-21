package ir.science.city.profile.mapper;

import ir.science.city.profile.dto.TeachingInformationDto;
import ir.science.city.profile.entity.TeachingInformation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface TeachingInformationMapper {
//    TeachingInformation toEntity(TeachingInformationDto dto);

    @Mappings({
            @Mapping(source = "type.name", target = "type"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "member", target = "member"),
            @Mapping(source = "id", target = "id")
    })
    TeachingInformationDto toDto(TeachingInformation entity);
}
