package ir.science.city.profile.api;

import ir.science.city.profile.dto.PersonalInformationDto;
import ir.science.city.profile.mapper.PersonalInformationMapper;
import ir.science.city.profile.service.PersonalInformationService;
import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnUpdate;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/personal-info")
@Validated
public class PersonalInformationController {

    private final PersonalInformationService service;
    private  final PersonalInformationMapper mapper = Mappers.getMapper(PersonalInformationMapper.class);

    @Autowired
    public PersonalInformationController(PersonalInformationService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<PersonalInformationDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable =  PageRequest.of(page, size, Sort.by("name").ascending());
        List<PersonalInformationDto> dtos = StreamSupport.stream(service.findAll(pageable).spliterator(), false)
                .map(mapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    ResponseEntity<PersonalInformationDto> get(@PathVariable("id") Long id) {
        return new ResponseEntity<>(mapper.toDto(service.findById(id)), HttpStatus.OK);
    }


    @PostMapping("/create")
    @Validated({OnCreate.class})
    ResponseEntity<PersonalInformationDto> create(@Valid @RequestBody PersonalInformationDto dto) {
        return new ResponseEntity<>(mapper.toDto(service.save(mapper.toEntity(dto))), HttpStatus.CREATED);
    }


    @PostMapping("/update")
    @Validated({OnUpdate.class})
    ResponseEntity<PersonalInformationDto> update(@Valid @RequestBody PersonalInformationDto dto) {
        return new ResponseEntity<>(mapper.toDto(service.save(mapper.toEntity(dto))), HttpStatus.OK);
    }

}
