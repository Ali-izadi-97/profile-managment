package ir.science.city.profile.service.impl;

import ir.science.city.profile.dto.ContactDto;
import ir.science.city.profile.entity.Contact;
import ir.science.city.profile.entity.PersonalInformation;
import ir.science.city.profile.mapper.ContactMapper;
import ir.science.city.profile.repository.ContactRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.ContactService;
import ir.science.city.profile.service.PersonalInformationService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.NotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class ContactServiceImpl extends GenericServiceImpl<Contact, Long> implements ContactService {

    private final ContactRepository repository;
    private final PersonalInformationService personalInformationService;
    private final ContactMapper mapper = Mappers.getMapper(ContactMapper.class);

    @Autowired
    public ContactServiceImpl(ContactRepository repository, PersonalInformationService personalInformationService) {
        this.repository = repository;
        this.personalInformationService = personalInformationService;
    }

    @Override
    protected GenericRepository<Contact, Long> getGeneralRepository() {
        return repository;
    }

    @Override
    public Contact save(ContactDto dto) throws NotFoundException {
        PersonalInformation personalInformation = personalInformationService.findById(dto.getPersonId());
        if (personalInformation != null) {
            Contact contact = repository.save(mapper.toEntity(dto));
            Long time = Instant.now().getEpochSecond();
            contact.setCreatedDate(time).setLastUpdate(time);
            personalInformation.addContact(contact);
            personalInformationService.save(personalInformation);
            return contact;
        }
        throw new NotFoundException("personal information with id " + dto.getPersonId() + " not found");
    }

    @Override
    public Contact update(ContactDto dto) throws NotFoundException {
        Contact contact = repository.findById(dto.getId())
                .orElseThrow(() -> new NotFoundException("this contact id not existed"));
        contact.setContent(dto.getContent()).setType(dto.getType())
                .setLastUpdate(Instant.now().getEpochSecond());
        return repository.save(contact);
    }
}



















