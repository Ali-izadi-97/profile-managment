package ir.science.city.profile.repository;

import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.repository.generic.GenericRepository;

import java.util.Optional;

public interface EducationTypeRepository extends GenericRepository<EducationType, Long> {
    Optional<EducationType> findEducationTypeByName(String name);
}
