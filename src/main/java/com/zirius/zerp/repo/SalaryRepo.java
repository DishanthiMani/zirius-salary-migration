package com.zirius.zerp.repo;


import com.zirius.cloud.db.DBServerService;
import com.zirius.cloud.db.pool.Database;
import com.zirius.cloud.db.where.DomainModel;
import com.zirius.zerp.model.erp.FirmaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class SalaryRepo {

    private static final Logger log = LoggerFactory.getLogger(SalaryRepo.class);

    private final String companyId;
    private final Connection connection;

    public SalaryRepo(String companyId) throws Exception {
        this.companyId = companyId;
        this.connection = Database.connection(companyId);
        this.connection.setAutoCommit(false); // disable auto-commit for all updates
    }


    public DomainModel getDomainModel() {
        DomainModel domainModel = new DomainModel();
        domainModel.setSchema("salary");
        domainModel.setCompany_id(String.valueOf(companyId));
        return domainModel;
    }

    public <T> void saveOrUpdate(T entity) throws Exception {

        DBServerService<T> dbService = new DBServerService<>((Class<T>) entity.getClass(), getDomainModel());
        dbService.saveWithException(entity);
    }


    public FirmaObject



    public void commit() throws Exception {
        connection.commit();
        connection.close();
    }

    public void rollback() throws Exception {
        connection.rollback();
        connection.close();
    }
}
