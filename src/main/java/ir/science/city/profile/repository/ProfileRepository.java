package ir.science.city.profile.repository;

import ir.science.city.profile.entity.Profile;
import ir.science.city.profile.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends GenericRepository<Profile, Long> {
}
