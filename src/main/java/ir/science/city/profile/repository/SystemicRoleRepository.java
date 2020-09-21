package ir.science.city.profile.repository;

import ir.science.city.profile.entity.SystemicRole;
import ir.science.city.profile.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SystemicRoleRepository extends GenericRepository<SystemicRole, Long> {
    Optional<SystemicRole> findByName(String name);
}
