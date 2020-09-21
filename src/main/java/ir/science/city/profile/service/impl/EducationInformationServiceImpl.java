package ir.science.city.profile.service.impl;

import ir.science.city.profile.dto.EducationInformationDto;
import ir.science.city.profile.entity.EducationInformation;
import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.repository.EducationInformationRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.EducationInformationService;
import ir.science.city.profile.service.EducationTypeService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class EducationInformationServiceImpl extends GenericServiceImpl<EducationInformation, Long> implements EducationInformationService {

    private final EducationInformationRepository repository;
    private final EducationTypeService educationTypeService;

    @Autowired
    public EducationInformationServiceImpl(EducationInformationRepository repository, EducationTypeService educationTypeService) {
        this.repository = repository;
        this.educationTypeService = educationTypeService;
    }

    @Override
    protected GenericRepository<EducationInformation, Long> getGeneralRepository() {
        return repository;
    }

    @Override
    public EducationInformation save(EducationInformationDto dto) throws DuplicateMemberException, NotFoundException {
        EducationType educationType = educationTypeService.getByName(dto.getName());
        if (repository.findByNameAndType(dto.getName(), educationType).isPresent())
            throw new DuplicateMemberException(String.format("edu info with name '%s' and type '%s' exist",
                    dto.getName(), dto.getType()));

        EducationInformation entity = new EducationInformation(dto.getName(), educationType);
        Long time = Instant.now().getEpochSecond();
        entity.setCreatedDate(time).setLastUpdate(time);
        return save(entity);
    }

    @Override
    public EducationInformation update(EducationInformationDto dto) throws NotFoundException {
        EducationInformation educationInformation = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("id " + dto.getId() + " not found"));
        EducationType educationType = educationTypeService.getByName(dto.getType());
        educationInformation.setName(dto.getName()).setType(educationType)
                .setLastUpdate(Instant.now().getEpochSecond());
        return save(educationInformation);
    }

    @Override
    public EducationInformation findEducationInformation(EducationInformationDto dto) throws NotFoundException {
        return repository.findByNameAndType(dto.getName(), educationTypeService.getByName(dto.getType())).orElseThrow();
    }
}
