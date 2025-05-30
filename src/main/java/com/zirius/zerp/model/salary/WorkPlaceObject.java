package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "work_place")
@Data
public class WorkPlaceObject {

    public static final String PROPERTYNAME_organizationno = "organizationno";
    public static final String PROPERTYNAME_municipality = "municipality";
    public static final String PROPERTYNAME_work_place_id = "WORK_PLACE_ID";
    public static final String PROPERTYNAME_work_place_code = "WORK_PLACE_CODE";
    public static final String PROPERTYNAME_work_place_name = "WORK_PLACE_NAME";
    public static final String PROPERTYNAME_business_number = "BUSINESS_NUMBER";
    public static final String PROPERTYNAME_company_id = "COMPANY_ID";
    public static final String PROPERTYNAME_municipality_id = "MUNICIPALITY_ID";
    public static final String PROPERTYNAME_is_deleted = "IS_DELETED";
    public static final String PROPERTYNAME_is_floating_work_place = "IS_FLOATING_WORK_PLACE";
    public static final String PROPERTYNAME_created_datetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modified_datetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_to_be_deleted = "TO_BE_DELETED";
    public static final String PROPERTYNAME_dbkey = "dbkey";
    public static final String table = "work_place";
    public static final String key = "work_place_id";

    @Id
    @Column(name = "WORK_PLACE_ID")
    private Integer workPlaceId;

    @Id
    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "WORK_PLACE_CODE")
    private String workPlaceCode;

    @Column(name = "WORK_PLACE_NAME")
    private String workPlaceName;

    @Column(name = "BUSINESS_NUMBER")
    private String businessNumber;

    @Column(name = "MUNICIPALITY_ID")
    private Integer municipalityId;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    @Column(name = "IS_FLOATING_WORK_PLACE")
    private Boolean isFloatingWorkPlace;

    @Column(name = "CREATED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDatetime;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;
}
