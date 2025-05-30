package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "migration_id_mapping")
@Data
public class MigrationIdMapping {

    public static final String PROPERTYNAME_tableName = "TABLE_NAME";
    public static final String PROPERTYNAME_oldId = "OLD_ID";
    public static final String PROPERTYNAME_newId = "NEW_ID";
    public static final String PROPERTY_companyId = "COMPANY_ID";

    @Id
    @Column(name = "TABLE_NAME", nullable = false, length = 100)
    private String tableName;

    @Id
    @Column(name = "OLD_ID", nullable = false)
    private Integer oldId;

    @Column(name = "NEW_ID")
    private Integer newId;

    @Column(name = "COMPANY_ID")
    private Integer companyId;
}
