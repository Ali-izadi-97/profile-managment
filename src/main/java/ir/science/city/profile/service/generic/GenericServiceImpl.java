package ir.science.city.profile.service.generic;

import ir.science.city.profile.repository.generic.GenericRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
@Validated
public abstract class GenericServiceImpl<T,PK extends Serializable> implements GenericService<T,PK> {

    protected abstract GenericRepository<T,PK> getGeneralRepository();

    @Override
    public T save(@Valid T entity) {
        return getGeneralRepository().save(entity);
    }

    @Override
    public void saveAll(@Valid Collection<T> entities) {
        getGeneralRepository().saveAll(entities);
    }

    @Override
    public T findById(PK id) {
        return getGeneralRepository().findById(id).orElse(null);
    }

    @Override
    public Iterable<T> findAll(Pageable var1) {
        return getGeneralRepository().findAll(var1).getContent();
    }

    @Override
    public Long countAll() {
        return getGeneralRepository().count();
    }

    @Override
    public void deleteById(PK id) {
        getGeneralRepository().deleteById(id);
    }

    @Override
    public void deleteAll(List<T> id) {
        getGeneralRepository().deleteAll();
    }
}
