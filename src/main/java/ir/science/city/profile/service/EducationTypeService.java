package ir.science.city.profile.service;

import ir.science.city.profile.dto.EducationTypeDto;
import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.service.generic.GenericService;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;


public interface EducationTypeService extends GenericService<EducationType, Long> {
    EducationType getByName(String name) throws NotFoundException;
    EducationType save(EducationTypeDto dto) throws DuplicateMemberException;
    EducationType update(EducationTypeDto dto) throws NotFoundException;
}
