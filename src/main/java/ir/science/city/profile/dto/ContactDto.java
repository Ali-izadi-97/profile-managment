package ir.science.city.profile.dto;

import ir.science.city.profile.entity.ContactType;
import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnDelete;
import ir.science.city.profile.valication.OnUpdate;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ContactDto {
    @Null(groups = OnCreate.class)
    @NotNull(groups = OnUpdate.class)
    @NotNull(groups = OnDelete.class)
    private Long id;

    @NotNull(groups = OnDelete.class)
    private Long personId;
    private ContactType type;

    private String content;
}
