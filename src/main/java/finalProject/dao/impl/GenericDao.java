package finalProject.dao.impl;

import finalProject.dao.IGenericDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * @param <T>
 * @param <PK>
 */
@Repository
public abstract class GenericDao<T, PK> implements IGenericDao<T, PK> {

    private Class<T> type;

    @Autowired
    private EntityManager entityManager;

    /**
     * Empty constructor. The real type T is found with generic reflection
     */
    GenericDao() {
        this.type = this.getParameterizedType(this.getClass());
    }


    public T find(long primaryKey) {
        return entityManager.find(type, primaryKey);
    }


    public List<T> findAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(type);
        Root<T> root = query.from(type);
        query.select(root);
        TypedQuery<T> tq = entityManager.createQuery(query);

        return tq.getResultList();
    }


    public void flush() {
        entityManager.flush();
    }

    List<T> getByCriteria(String key, Object value) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        query.where(builder.equal(root.get(key), value));
        return entityManager.createQuery(query).getResultList();
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Generic reflection. Find and set generic type used
     */
    @SuppressWarnings("unchecked")
    private Class<T> getParameterizedType(Class<?> clazz) {
        Class<T> specificType;
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return specificType;
    }


    public T getReference(long primaryKey) {
        return entityManager.getReference(type, primaryKey);
    }

    /**
     * @return the type
     */
    public Class<T> getType() {
        return type;
    }


    public T merge(T o) {
        return entityManager.merge(o);
    }


    public void persist(T o) {
        entityManager.persist(o);
    }


    public void refresh(T o) {
        entityManager.refresh(o);
    }


    public void remove(T o) {
        entityManager.remove(o);
    }

    /**
     * @param entityManager the entityManager to set
     */
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * @param type the type to set
     */
    public void setType(Class<T> type) {
        this.type = type;
    }
}