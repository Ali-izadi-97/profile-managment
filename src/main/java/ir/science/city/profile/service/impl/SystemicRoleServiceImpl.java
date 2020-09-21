package ir.science.city.profile.service.impl;

import ir.science.city.profile.entity.SystemicRole;
import ir.science.city.profile.repository.SystemicRoleRepository;
import ir.science.city.profile.repository.generic.GenericRepository;
import ir.science.city.profile.service.SystemicRoleService;
import ir.science.city.profile.service.generic.GenericServiceImpl;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SystemicRoleServiceImpl extends GenericServiceImpl<SystemicRole, Long> implements SystemicRoleService {

    private final SystemicRoleRepository repository;

    @Autowired
    public SystemicRoleServiceImpl(SystemicRoleRepository repository) {
        this.repository = repository;
    }

    @Override
    protected GenericRepository<SystemicRole, Long> getGeneralRepository() {
        return null;
    }

    @Override
    public SystemicRole getByName(String name) throws NotFoundException {
        return repository.findByName(name).orElseThrow(() -> new NotFoundException(""));
    }
}
