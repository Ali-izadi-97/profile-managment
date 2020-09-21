package ir.science.city.profile.repository;

import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.entity.Member;
import ir.science.city.profile.entity.TeachingInformation;
import ir.science.city.profile.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeachingInformationRepository extends GenericRepository<TeachingInformation, Long> {
    Optional<TeachingInformation> findByNameAndTypeAndMember(String name, EducationType type, Member member);
}
