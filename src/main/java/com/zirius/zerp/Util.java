package com.zirius.zerp;

import com.zirius.zerp.model.salary.MigrationIdMapping;
import com.zirius.zerp.model.salary.SalaryGroupObject;
import com.zirius.zerp.model.zerp.SalaryGroup;
import com.zirius.zerp.repository.erp.ErpGeneralRepository;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;

public class Util {

    @Autowired
    private ErpGeneralRepository erpRepo;

    @Autowired
    private CompanyConfigRepository companyConfigRepository;


    public void updateMigrationTableDetails(Integer newId, Integer oldId, String tableName, Integer companyId) {
        MigrationIdMapping migrationIdMapping = new MigrationIdMapping();
        migrationIdMapping.setTableName(tableName);
        migrationIdMapping.setOldId(oldId);
        migrationIdMapping.setNewId(newId);
        migrationIdMapping.setCompanyId(companyId);
        companyConfigRepository.save(migrationIdMapping);
        System.out.println("Migration id mapping data ********************" + migrationIdMapping.toString());
    }
}
