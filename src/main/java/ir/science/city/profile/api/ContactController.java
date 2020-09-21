package ir.science.city.profile.api;

import ir.science.city.profile.dto.ContactDto;
import ir.science.city.profile.mapper.ContactMapper;
import ir.science.city.profile.service.ContactService;
import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnDelete;
import ir.science.city.profile.valication.OnUpdate;
import javassist.NotFoundException;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/contact")
@Validated
public class ContactController {

    private final ContactService service;
    private final ContactMapper mapper = Mappers.getMapper(ContactMapper.class);

    @Autowired
    public ContactController(ContactService service) {
        this.service = service;
    }


    @PostMapping("/create")
    @Validated(OnCreate.class)
    public ResponseEntity<ContactDto> create(@Valid @RequestBody ContactDto dto) throws NotFoundException {
        System.out.println(dto);
        ContactDto contactDto = mapper.toDto(service.save(dto));
        contactDto.setPersonId(dto.getPersonId());
        return new ResponseEntity<>(contactDto, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Validated(OnUpdate.class)
    public ResponseEntity<ContactDto> update(@Valid @RequestBody ContactDto dto) throws NotFoundException {
        ContactDto contactDto = mapper.toDto(service.update(dto));
        contactDto.setPersonId(dto.getPersonId());
        return new ResponseEntity<>(contactDto, HttpStatus.OK);
    }

    @GetMapping("/delete")
//    @Validated(OnDelete.class)
    public ResponseEntity<?> delete(@RequestParam("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
