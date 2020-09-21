package ir.science.city.profile.service.impl;

import ir.science.city.profile.dto.EducationTypeDto;
import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.mapper.EducationTypeMapper;
import ir.science.city.profile.repository.EducationTypeRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.EducationTypeService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;


@Service
public class EducationTypeServiceImpl extends GenericServiceImpl<EducationType, Long> implements EducationTypeService {

    private final EducationTypeRepository repository;
    private final EducationTypeMapper mapper = Mappers.getMapper(EducationTypeMapper.class);

    @Autowired
    public EducationTypeServiceImpl(EducationTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<EducationType, Long> getGeneralRepository() {
        return repository;
    }

    @Override
    public EducationType getByName(String name) throws NotFoundException {
        return repository.findEducationTypeByName(name).orElseThrow(() -> new NotFoundException(""));
    }

    @Override
    public EducationType save(EducationTypeDto dto) throws DuplicateMemberException {
        Optional<EducationType> educationType = repository.findEducationTypeByName(dto.getName());
        if (educationType.isPresent()) {
            throw new DuplicateMemberException("type " + dto.getName() + " is exist");
        }
        EducationType entity = mapper.toEntity(dto);
        Long time = Instant.now().getEpochSecond();
        entity.setCreatedDate(time).setLastUpdate(time);
        return save(entity);
    }

    @Override
    public EducationType update(EducationTypeDto dto) throws NotFoundException {
        EducationType educationType = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("id " + dto.getId() + " not found"));
        educationType.setName(dto.getName()).setLastUpdate(Instant.now().getEpochSecond());
        return repository.save(educationType);
    }
}
