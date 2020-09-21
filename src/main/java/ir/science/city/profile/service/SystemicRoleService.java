package ir.science.city.profile.service;

import ir.science.city.profile.entity.SystemicRole;
import ir.science.city.profile.service.generic.GenericService;
import javassist.NotFoundException;

public interface SystemicRoleService extends GenericService<SystemicRole, Long> {
    SystemicRole getByName(String name) throws NotFoundException;
}
