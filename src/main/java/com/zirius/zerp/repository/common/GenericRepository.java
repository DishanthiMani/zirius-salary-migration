package com.zirius.zerp.repository.common;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public abstract class GenericRepository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    // Find by primary key
    public Optional<T> findById(Class<T> entityClass, Object id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    // Find by single column
    public Optional<T> findByColumn(Class<T> entityClass, String column, Object value) {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e WHERE e." + column + " = :value";
        return entityManager.createQuery(jpql, entityClass)
                .setParameter("value", value)
                .getResultStream()
                .findFirst();
    }

    // Find by multiple filters
    public List<T> findByFilters(Class<T> entityClass, Map<String, Object> filters) {
        StringBuilder jpql = new StringBuilder("SELECT e FROM " + entityClass.getSimpleName() + " e WHERE 1=1");

        filters.keySet().forEach(column -> jpql.append(" AND e.").append(column).append(" = :").append(column));

        TypedQuery<T> query = entityManager.createQuery(jpql.toString(), entityClass);
        filters.forEach(query::setParameter);

        return query.getResultList();
    }

    // Save
    public void save(T entity) {
        entityManager.persist(entity);
    }

    // Update
    public T update(T entity) {
        return entityManager.merge(entity);
    }
}
