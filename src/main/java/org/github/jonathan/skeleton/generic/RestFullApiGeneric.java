package org.github.jonathan.skeleton.generic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface RestFullApiGeneric<T extends Serializable> extends JpaRepository<T, Long> {
    T findById(long id);
}
