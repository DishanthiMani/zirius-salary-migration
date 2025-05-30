package com.zirius.zerp.repository.salary;


import com.zirius.zerp.model.salary.MigrationIdMapping;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class CompanyConfigRepository {

    @PersistenceContext(unitName = "salary")
    private EntityManager entityManager;

    @Transactional
    public <T> T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public MigrationIdMapping getMigrationMappingValue(String tableName, Integer oldId, Integer companyId) {

        String query = "SELECT c FROM MigrationIdMapping c WHERE c.tableName = :tableName AND c.oldId = :oldId, c.companyId = :companyId";

        return entityManager.createQuery(query, MigrationIdMapping.class).setParameter("tableName", tableName).setParameter("oldId", oldId)
                .setParameter("companyId", companyId).getSingleResult();
    }

}
