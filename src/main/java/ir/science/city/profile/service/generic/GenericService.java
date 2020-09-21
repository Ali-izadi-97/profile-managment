package ir.science.city.profile.service.generic;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Service
public interface GenericService<T, PK extends Serializable> {

    T save(@Valid T entity);

    void saveAll(@Valid Collection<T> entity);

    T findById(PK id);

    Iterable<T> findAll(Pageable var1);

    Long countAll();

    void deleteById(PK id);

    void deleteAll(List<T> id);

}
