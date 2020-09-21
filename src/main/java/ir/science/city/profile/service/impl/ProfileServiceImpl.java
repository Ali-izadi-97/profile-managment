package ir.science.city.profile.service.impl;

import ir.science.city.profile.dto.ProfileDto;
import ir.science.city.profile.dto.ProfileResponseDto;
import ir.science.city.profile.entity.EducationInformation;
import ir.science.city.profile.entity.Profile;
import ir.science.city.profile.entity.TeachingInformation;
import ir.science.city.profile.repository.ProfileRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.EducationInformationService;
import ir.science.city.profile.service.PersonalInformationService;
import ir.science.city.profile.service.ProfileService;
import ir.science.city.profile.service.TeachingInformationService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.bytecode.DuplicateMemberException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProfileServiceImpl extends GenericServiceImpl<Profile, Long> implements ProfileService {

    private final ProfileRepository repository;
    private final PersonalInformationService personalInformationService;
    private final EducationInformationService educationInformationService;
    private final TeachingInformationService teachingInformationService;

    @Autowired
    public ProfileServiceImpl(ProfileRepository repository,
                              PersonalInformationService personalInformationService,
                              EducationInformationService educationInformationService,
                              TeachingInformationService teachingInformationService) {
        this.repository = repository;
        this.personalInformationService = personalInformationService;
        this.educationInformationService = educationInformationService;
        this.teachingInformationService = teachingInformationService;
    }

    @Override
    protected GenericRepository<Profile, Long> getGeneralRepository() {
        return repository;
    }

    @Override
    @Transactional
    public Profile save(ProfileDto dto) throws DuplicateMemberException {
        Profile profile = new Profile();
        profile.setPersonalInformation(personalInformationService.save(dto.getPersonalInformationDto()));
        findAllEducationInformations((dto.getEducationInformationsCode())).forEach(profile::addEducationInformation);
        findAllTeachingInformations(dto.getTeachingInformationsCode()).forEach(profile::addTeachingInformation);
        return save(profile);
    }

    @Override
    public Profile update(ProfileDto dto) {
        return null;
    }

    @Override
    public ProfileResponseDto findAll() {
        Iterator<Profile> iterator = repository.findAll().iterator();
        return null;
    }

    private List<EducationInformation> findAllEducationInformations(List<Long> ids) {
        List<EducationInformation> informations = new ArrayList<>();
        for (Long id : ids) {
            informations.add(educationInformationService.findById(id));
        }
        return informations;
    }

    private List<TeachingInformation> findAllTeachingInformations(List<Long> ids) {
        List<TeachingInformation> informations = new ArrayList<>();
        for (Long id : ids) {
            informations.add(teachingInformationService.findById(id));
        }
        return informations;
    }
}
