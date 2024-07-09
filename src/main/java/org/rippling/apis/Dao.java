package org.rippling.apis;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> getById(long id);

    List<T> getAll();

    T save(T t);

    void update(T t, String[] params);

    void deleteById(long id);
}
