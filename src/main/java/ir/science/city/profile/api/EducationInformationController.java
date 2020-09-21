package ir.science.city.profile.api;

import ir.science.city.profile.dto.EducationInformationDto;
import ir.science.city.profile.dto.EducationTypeDto;
import ir.science.city.profile.entity.EducationInformation;
import ir.science.city.profile.entity.EducationType;
import ir.science.city.profile.mapper.EducationInformationMapper;
import ir.science.city.profile.service.EducationInformationService;
import ir.science.city.profile.valication.OnCreate;
import ir.science.city.profile.valication.OnUpdate;
import javassist.NotFoundException;
import javassist.bytecode.DuplicateMemberException;
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
@RequestMapping("/api/edu-info")
@Validated
public class EducationInformationController {

    private final EducationInformationService service;
    private final EducationInformationMapper mapper = Mappers.getMapper(EducationInformationMapper.class);

    @Autowired
    public EducationInformationController(EducationInformationService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<EducationInformationDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        List<EducationInformationDto> dtos = StreamSupport.stream(service.findAll(pageable).spliterator(), false)
                .map(mapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EducationInformationDto> get(@PathVariable("id") Long id) {
        EducationInformationDto dto = mapper.toDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping("/create")
    @Validated({OnCreate.class})
    public ResponseEntity<EducationInformationDto> create(@Valid @RequestBody EducationInformationDto dto)
            throws DuplicateMemberException, NotFoundException {
        return new ResponseEntity<>(mapper.toDto(service.save(dto)), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Validated({OnUpdate.class})
    public ResponseEntity<EducationInformationDto> update(@Valid @RequestBody EducationInformationDto dto)
            throws NotFoundException {
        return new ResponseEntity<>(mapper.toDto(service.update(dto)), HttpStatus.OK);
    }

}
