package org.github.jonathan.skeleton.generic;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface RestFullApiGeneric<T> extends JpaRepository<T, Long> {
    T findById(long id);
}
