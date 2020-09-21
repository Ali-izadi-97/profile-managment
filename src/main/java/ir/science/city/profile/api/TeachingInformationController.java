package ir.science.city.profile.api;

import ir.science.city.profile.dto.TeachingInformationDto;
import ir.science.city.profile.mapper.TeachingInformationMapper;
import ir.science.city.profile.service.TeachingInformationService;
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

@RestController()
@RequestMapping("/api/teach-info")
@Validated
public class TeachingInformationController {

    private final TeachingInformationService service;
    private final TeachingInformationMapper mapper = Mappers.getMapper(TeachingInformationMapper.class);

    @Autowired
    public TeachingInformationController(TeachingInformationService teachingInformationService) {
        this.service = teachingInformationService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<TeachingInformationDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("name").ascending());
        List<TeachingInformationDto> dtos = StreamSupport.stream(service.findAll(pageable).spliterator(), false)
                .map(mapper::toDto).collect(Collectors.toList());
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<TeachingInformationDto> get(@PathVariable("id") Long id) {
        TeachingInformationDto dto = mapper.toDto(service.findById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping("/create")
    @Validated({OnCreate.class})
    public ResponseEntity<TeachingInformationDto> create(@RequestBody @Valid TeachingInformationDto dto)
            throws DuplicateMemberException, NotFoundException {
        System.out.println(dto);
        return new ResponseEntity<>(mapper.toDto(service.save(dto)), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    @Validated({OnUpdate.class})
    public ResponseEntity<TeachingInformationDto> update(@Valid @RequestBody TeachingInformationDto dto) {
        System.out.println(dto);
        return null;
    }


}
