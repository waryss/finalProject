package project.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDate;
import java.util.List;


/**
 * @param <T>
 * @param <PK>
 */
@Repository
public abstract class GenericDaoImpl<T, PK> implements project.dao.GenericDao<T, PK> {

    private Class<T> type;

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Empty constructor. The real type T is found with generic reflection
     */
    GenericDaoImpl() {
        this.type = this.getParameterizedType(this.getClass());
    }


    public T find(PK primaryKey) {
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

    public List<T> getByCriteria(String key, Object value) {
        System.out.println("dans la finction entityManager = " + entityManager);
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


    public T getReference(PK primaryKey) {
        return entityManager.getReference(type, primaryKey);
    }

    /**
     * @return the type
     */
    public Class<T> getType() {
        return type;
    }

    @Transactional
    public T merge(T o) {
        return entityManager.merge(o);
    }

    @Transactional
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