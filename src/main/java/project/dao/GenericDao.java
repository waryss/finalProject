package project.dao;

import java.util.List;

/**
 *
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK> {

    void flush();

    void refresh(T o);

    void persist(T o);

    void remove(T o);

    T merge(T o);

    T find(long l);

    T getReference(long userId);

    List<T> findAll();
}