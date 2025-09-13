package com.zirius.zerp.repository.erp;


import com.zirius.zerp.model.erp.FirmaObject;
import com.zirius.zerp.repository.common.GenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ErpGeneralRepository extends GenericRepository {

    @PersistenceContext
    private EntityManager entityManager;


    public FirmaObject getFirmaObjectData(Integer companyId) {
        return (FirmaObject) findById(FirmaObject.class,companyId).orElse(null);
    }

}
