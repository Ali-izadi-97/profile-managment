package ir.science.city.profile.service;

import ir.science.city.profile.dto.ProfileDto;
import ir.science.city.profile.dto.ProfileResponseDto;
import ir.science.city.profile.entity.Profile;
import ir.science.city.profile.service.generic.GenericService;
import javassist.bytecode.DuplicateMemberException;

public interface ProfileService extends GenericService<Profile, Long> {
    Profile save(ProfileDto dto) throws DuplicateMemberException;
    Profile update(ProfileDto dto);
    ProfileResponseDto findAll();
}
