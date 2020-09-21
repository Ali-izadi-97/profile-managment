package ir.science.city.profile.service.impl;

import ir.science.city.profile.dto.PersonalInformationDto;
import ir.science.city.profile.entity.PersonalInformation;
import ir.science.city.profile.mapper.PersonalInformationMapper;
import ir.science.city.profile.repository.PersonalInformationRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.PersonalInformationService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Optional;


@Service
public class PersonalInformationServiceImpl extends GenericServiceImpl<PersonalInformation, Long>
        implements PersonalInformationService {

    private final PersonalInformationRepository repository;
    private final PersonalInformationMapper mapper = Mappers.getMapper(PersonalInformationMapper.class);

    @Autowired
    public PersonalInformationServiceImpl(PersonalInformationRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<PersonalInformation, Long> getGeneralRepository() {
        return repository;
    }

    @Override
    public PersonalInformation getByCode(String code) {
        return repository.findPersonalInformationByNationalCode(code)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public PersonalInformation save(PersonalInformationDto dto) throws DuplicateMemberException {
        Optional<PersonalInformation> personalInformation = repository
                .findPersonalInformationByNationalCode(dto.getNationalCode());
        if (personalInformation.isPresent())
            throw new DuplicateMemberException("person with national code " + dto.getNationalCode() + " is exist");

        PersonalInformation entity = mapper.toEntity(dto);
        Long time = Instant.now().getEpochSecond();
        entity.setCreatedDate(time).setLastUpdate(time);
        return save(entity);
    }

    @Override
    public PersonalInformation update(PersonalInformationDto dto) throws NotFoundException {
        PersonalInformation personalInformation = repository
                .findByIdAndNationalCode(dto.getId(), dto.getNationalCode())
                .orElseThrow(() -> new NotFoundException("id " + dto.getId() + " not found"));
        personalInformation
                .setFirstName(dto.getFirstName()).setLastName(dto.getLastName())
                .setNationalCode(dto.getNationalCode()).setMainPhone(dto.getMainPhone())
                .setAddress(dto.getAddress()).setGender(dto.getGender()).setBirthDate(dto.getBirthDate())
                .setMarital(dto.getMarital()).setPhoto(dto.getPhoto())
                .setLastUpdate(Instant.now().getEpochSecond());
        return save(personalInformation);
    }
}
