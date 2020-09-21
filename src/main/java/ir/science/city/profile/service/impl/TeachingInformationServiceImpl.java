package ir.science.city.profile.service.impl;

import ir.science.city.profile.dto.TeachingInformationDto;
import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.entity.TeachingInformation;
import ir.science.city.profile.mapper.TeachingInformationMapper;
import ir.science.city.profile.repository.TeachingInformationRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.EducationTypeService;
import ir.science.city.profile.service.TeachingInformationService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class TeachingInformationServiceImpl extends GenericServiceImpl<TeachingInformation, Long>
        implements TeachingInformationService {

    private final TeachingInformationRepository repository;
    private final EducationTypeService educationTypeService;
    private final TeachingInformationMapper mapper = Mappers.getMapper(TeachingInformationMapper.class);

    @Autowired
    public TeachingInformationServiceImpl(TeachingInformationRepository repository, EducationTypeService educationTypeService) {
        this.repository = repository;
        this.educationTypeService = educationTypeService;
    }

    @Override
    protected GenericRepository<TeachingInformation, Long> getGeneralRepository() {
        return repository;
    }

    @Override
    public TeachingInformation save(TeachingInformationDto dto) throws DuplicateMemberException, NotFoundException {
        EducationType type = educationTypeService.getByName(dto.getType());
        Optional<TeachingInformation> teachingInformation =
                repository.findByNameAndTypeAndMember(dto.getName(), type, dto.getMember());
        if (teachingInformation.isPresent())
            throw new DuplicateMemberException("teaching information exist");

        TeachingInformation entity = new TeachingInformation(dto.getName(), type, dto.getMember());
        long time = Instant.now().getEpochSecond();
        entity.setCreatedDate(time).setLastUpdate(time);
        return save(new TeachingInformation(dto.getName(), type, dto.getMember()));
    }

    @Override
    public TeachingInformation update(TeachingInformationDto dto) throws NotFoundException {
        EducationType type = educationTypeService.getByName(dto.getType());
        TeachingInformation teachingInformation = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("id " + dto.getId() + " not found"));
        teachingInformation.setName(dto.getName()).setMember(dto.getMember())
                .setType(type).setLastUpdate(Instant.now().getEpochSecond());
        return save(teachingInformation);
    }
}
