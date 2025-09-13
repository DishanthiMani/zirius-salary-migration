package com.zirius.zerp.repository.salary;


import com.zirius.zerp.model.salary.CompanyFreeCarDetailsObject;
import com.zirius.zerp.model.salary.CompanySalaryDetailsObject;
import com.zirius.zerp.model.salary.MigrationIdMapping;
import com.zirius.zerp.model.salary.StandardSalaryCodeDetails;
import com.zirius.zerp.model.salary.WorkPlaceObject;
import com.zirius.zerp.model.zerp.CompanySalaryDetails;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyConfigRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public <T> T save(T entity) {
//        entityManager.persist(entity);
        return entity;
    }

    @Transactional
    public <T> T update(T entity) {
//        entityManager.merge(entity);
        return entity;

    }


    public MigrationIdMapping getMigrationMappingValue(String tableName, Integer oldId, Integer companyId) {

        String query = "SELECT c FROM MigrationIdMapping c WHERE c.tableName = :tableName AND c.oldId = :oldId, c.companyId = :companyId";

        return entityManager.createQuery(query, MigrationIdMapping.class).setParameter("tableName", tableName).setParameter("oldId", oldId)
                .setParameter("companyId", companyId).getSingleResult();
    }

    public List<StandardSalaryCodeDetails> getStandardSalaryReportingCodeDetails() {

        String query = "SELECT c FROM StandardSalaryCodeDetails c";

        return entityManager.createQuery(query, StandardSalaryCodeDetails.class).getResultList();
    }

    public Integer getMaximumSalaryReportingCodeId() {

        String query = "SELECT MAX(s.salaryReportingCodeId) FROM SalaryReportingCodeDetails s";

        Integer maxId = entityManager.createQuery(query, Integer.class)
                .getSingleResult();

        return maxId != null ? maxId : 0;
    }

    public CompanySalaryDetailsObject getCompanySalaryDetails(Integer companyId) {

        String query = "SELECT c FROM CompanySalaryDetailsObject c WHERE c.companyId =:companyId";

        return entityManager.createQuery(query, CompanySalaryDetailsObject.class).setParameter("companyId", companyId).getSingleResult();
    }

    public List<WorkPlaceObject> getWorkPlaceList(Integer companyId) {

        String query = "SELECT c FROM WorkPlaceObject c WHERE c.companyId =:companyId";

        return entityManager.createQuery(query, WorkPlaceObject.class).setParameter("companyId", companyId).getResultList();
    }

    public List<CompanyFreeCarDetailsObject> getCompanyFreeCarDetails(Integer companyId) {

        String query = "SELECT c FROM CompanyFreeCarDetailsObject c WHERE c.companyId =:companyId";
        return entityManager.createQuery(query, CompanyFreeCarDetailsObject.class).setParameter("companyId", companyId).getResultList();
    }

}
