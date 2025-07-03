package ru.v1nga.todo.core.database;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс для реализации базовых операций CRUD с сущностями.
 *
 * @param <T>  тип сущности
 * @param <ID> тип идентификатора
 */
public interface CrudRepository<T, ID> {

    T save(T entity);

    List<T> saveAll(List<T> entities);

    Optional<T> findById(ID id);

    boolean existsById(ID id);

    List<T> findAll();

    long count();

    void deleteById(ID id);

    void delete(T entity);
}
