package ir.science.city.profile.mapper;

import ir.science.city.profile.dto.ContactDto;
import ir.science.city.profile.entity.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface ContactMapper {
    ContactDto toDto(Contact entity);

    @Mappings({
            @Mapping(source = "type", target = "type"),
            @Mapping(source = "content", target = "content")
    })
    Contact toEntity(ContactDto dto);
}
