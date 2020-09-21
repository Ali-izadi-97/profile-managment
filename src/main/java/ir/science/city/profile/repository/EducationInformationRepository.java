package ir.science.city.profile.repository;

import ir.science.city.profile.entity.EducationInformation;
import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.repository.generic.GenericRepository;

import java.util.Optional;

public interface EducationInformationRepository extends GenericRepository<EducationInformation, Long> {
    Optional<EducationInformation> findByNameAndType(String name, EducationType type);
}
