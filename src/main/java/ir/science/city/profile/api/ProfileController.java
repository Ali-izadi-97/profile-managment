package ir.science.city.profile.api;

import ir.science.city.profile.dto.ProfileDto;
import ir.science.city.profile.dto.ProfileResponseDto;
import ir.science.city.profile.service.ProfileService;
import ir.science.city.profile.valication.OnCreate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/profile")
@Validated
public class ProfileController {

    private final ProfileService service;

    @Autowired
    public ProfileController(ProfileService service) {
        this.service = service;
    }

    @GetMapping("/get")
    public ResponseEntity<List<ProfileResponseDto>> getAll(@RequestParam("page") int page, @RequestParam("size") int size) {
        Pageable pageable =  PageRequest.of(page, size, Sort.by("name").ascending());
        return null;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ProfileResponseDto> get(@PathVariable("id") Long id) {
        return null;
    }


    @PostMapping("/create")
    @Validated(OnCreate.class)
    public void create(@RequestBody ProfileDto dto) {
        System.out.println(dto);
    }
}
