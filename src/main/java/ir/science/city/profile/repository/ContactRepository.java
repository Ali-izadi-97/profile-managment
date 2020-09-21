package ir.science.city.profile.repository;

import ir.science.city.profile.entity.Contact;
import ir.science.city.profile.repository.generic.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends GenericRepository<Contact, Long> {
}
