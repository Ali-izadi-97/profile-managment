package ir.science.city.profile.service;

import ir.science.city.profile.dto.TeachingInformationDto;
import ir.science.city.profile.entity.TeachingInformation;
import ir.science.city.profile.service.generic.GenericService;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;

public interface TeachingInformationService extends GenericService<TeachingInformation, Long> {
    TeachingInformation save(TeachingInformationDto dto) throws DuplicateMemberException, NotFoundException;
    TeachingInformation update(TeachingInformationDto dto) throws NotFoundException;
}
