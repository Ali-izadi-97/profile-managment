package ir.science.city.profile.service;

import ir.science.city.profile.dto.ContactDto;
import ir.science.city.profile.entity.Contact;
import ir.science.city.profile.service.generic.GenericService;
import javassist.NotFoundException;

public interface ContactService extends GenericService<Contact, Long> {
    Contact save(ContactDto dto) throws NotFoundException;
    Contact update(ContactDto dto) throws NotFoundException;
}
