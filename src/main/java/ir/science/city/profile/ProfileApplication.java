package ir.science.city.profile;

import ir.science.city.profile.dto.PersonalInformationDto;
import ir.science.city.profile.entity.EducationInformation;
import ir.science.city.profile.entity.Gender;
import ir.science.city.profile.entity.Marital;
import ir.science.city.profile.entity.PersonalInformation;
import ir.science.city.profile.mapper.PersonalInformationMapper;
import ir.science.city.profile.repository.ContactRepository;
import ir.science.city.profile.repository.PersonalInformationRepository;
import ir.science.city.profile.service.ContactService;
import ir.science.city.profile.service.EducationInformationService;
import ir.science.city.profile.service.PersonalInformationService;
import ir.science.city.profile.service.ProfileService;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.transaction.Transactional;

@SpringBootApplication
public class ProfileApplication  implements CommandLineRunner {

    @Autowired
    ContactService service;

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    PersonalInformationRepository pers;

    @Autowired
    ProfileService profileService;

    private PersonalInformationMapper mapper = Mappers.getMapper(PersonalInformationMapper.class);

    public static void main(String[] args)
    {
        SpringApplication.run(ProfileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println(pers.findAll());
//        PersonalInformation information1 = PersonalInformation.builder().firstName("cdcd")
//                .gender(Gender.MAN)
//                .marital(Marital.MARRIED)
//                .firstName("ali")
//                .lastName("iadi").address("ckd d cidcid cdi")
//                .nationalCode("123")
//                .build();
//
////        PersonalInformation information = new PersonalInformation("cdcd", "cdcd");
//        PersonalInformation ret = service.save(information1);
//        PersonalInformationDto dto = mapper.toDto(ret);
//
//        System.out.println(ret);
//        System.out.println(dto);
//
//        educationInformationService.save(new EducationInformation());
        Pageable pageable = PageRequest.of(0, 10, Sort.by("id"));
//        System.out.println(service.findAll(pageable));
        System.out.println(service.findAll(pageable));
        service.deleteById(1L);
    }
}
