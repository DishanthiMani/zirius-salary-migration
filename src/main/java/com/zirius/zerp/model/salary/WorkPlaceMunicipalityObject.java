package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "work_place_municipality")
@Data
public class WorkPlaceMunicipalityObject {

    public static final String PROPERTYNAME_work_place_municipality_id = "WORK_PLACE_MUNICIPALITY_ID";
    public static final String PROPERTYNAME_company_id = "COMPANY_ID";
    public static final String PROPERTYNAME_work_place_id = "WORK_PLACE_ID";
    public static final String PROPERTYNAME_year = "YEAR";
    public static final String PROPERTYNAME_municipality_id = "MUNICIPALITY_ID";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_created_datetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modified_datetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_to_be_deleted = "TO_BE_DELETED";
    public static final String table = "work_place_municipality";
    public static final String key = "work_place_municipality_id";

    @Id
    @Column(name = "WORK_PLACE_MUNICIPALITY_ID")
    private Integer workPlaceMunicipalityId;

    @Id
    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "WORK_PLACE_ID")
    private Integer workPlaceId;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "MUNICIPALITY_ID")
    private Integer municipalityId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;
}
