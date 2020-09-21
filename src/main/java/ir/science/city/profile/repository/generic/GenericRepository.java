package ir.science.city.profile.repository.generic;


import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface GenericRepository<T, PK extends Serializable> extends PagingAndSortingRepository<T, PK> {
}
