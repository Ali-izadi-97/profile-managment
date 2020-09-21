package ir.science.city.profile.repository;

import ir.science.city.profile.entity.PersonalInformation;
import ir.science.city.profile.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonalInformationRepository extends GenericRepository<PersonalInformation, Long> {
    Optional<PersonalInformation> findPersonalInformationByNationalCode(String code);
    Optional<PersonalInformation> findByIdAndNationalCode(Long id, String code);
}
