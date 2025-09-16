package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class MigrationIdMapping {

    public static final String PROPERTYNAME_tableName = "TABLE_NAME";
    public static final String PROPERTYNAME_oldId = "OLD_ID";
    public static final String PROPERTYNAME_newId = "NEW_ID";
    public static final String PROPERTY_companyId = "COMPANY_ID";


    @Column(name = "TABLE_NAME", nullable = false, length = 100)
    private String tableName;


    @Column(name = "OLD_ID", nullable = false)
    private Integer oldId;

    @Column(name = "NEW_ID")
    private Integer newId;

    @Column(name = "COMPANY_ID")
    private Integer companyId;
}
