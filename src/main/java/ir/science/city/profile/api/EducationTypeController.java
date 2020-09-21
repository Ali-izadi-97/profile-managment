package ir.science.city.profile.api;

import ir.science.city.profile.dto.EducationTypeDto;
import ir.science.city.profile.mapper.EducationTypeMapper;
import ir.science.city.profile.service.EducationTypeService;
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
@RequestMapping("/api/edu-type")
@Validated
public class EducationTypeController {


    private final EducationTypeService service;
    private final EducationTypeMapper mapper = Mappers.getMapper(EducationTypeMapper.class);

    @Autowired
    public EducationTypeController(EducationTypeService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<EducationTypeDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        List<EducationTypeDto> dtos = StreamSupport.stream(service.findAll(pageable).spliterator(), false)
                .map(mapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<EducationTypeDto> get(@PathVariable("id") Long id, @RequestParam("page") int page, @RequestParam("size") int size) {
        EducationTypeDto dto = mapper.toDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping("/create")
    @Validated({OnCreate.class})
    public ResponseEntity<EducationTypeDto> create(@Valid @RequestBody EducationTypeDto dto) throws DuplicateMemberException {
        return new ResponseEntity<>(mapper.toDto(service.save(dto)), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Validated({OnUpdate.class})
    public ResponseEntity<EducationTypeDto> update(@Valid @RequestBody EducationTypeDto dto) throws NotFoundException {
        return new ResponseEntity<>(mapper.toDto(service.update(dto)), HttpStatus.OK);
    }

}
