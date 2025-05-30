package com.zirius.zerp.repository.erp;


import com.zirius.zerp.model.erp.FirmaObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ErpGeneralRepository {

    @PersistenceContext(unitName = "erp")
    private EntityManager entityManager;

    public FirmaObject getFirmaObjectData(String organizationNumber) {
        return entityManager.createQuery("SELECT c FROM FirmaObject c WHERE c.ORGNR = :orgNo", FirmaObject.class)
                .setParameter("orgNo", organizationNumber).getSingleResult();
    }
}
