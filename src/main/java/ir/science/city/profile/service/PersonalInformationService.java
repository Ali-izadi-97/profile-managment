package ir.science.city.profile.service;

import ir.science.city.profile.dto.PersonalInformationDto;
import ir.science.city.profile.entity.PersonalInformation;
import ir.science.city.profile.service.generic.GenericService;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;


public interface PersonalInformationService extends GenericService<PersonalInformation, Long> {
    PersonalInformation getByCode(String code);
    PersonalInformation save(PersonalInformationDto dto) throws DuplicateMemberException;
    PersonalInformation update(PersonalInformationDto dto) throws NotFoundException;
}
