package ir.science.city.profile.service;

import ir.science.city.profile.dto.EducationInformationDto;
import ir.science.city.profile.entity.EducationInformation;
import ir.science.city.profile.service.generic.GenericService;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;

public interface EducationInformationService extends GenericService<EducationInformation, Long> {
    EducationInformation save(EducationInformationDto dto) throws DuplicateMemberException, NotFoundException;
    EducationInformation update(EducationInformationDto dto) throws NotFoundException;
    EducationInformation findEducationInformation(EducationInformationDto dto) throws NotFoundException;
}
