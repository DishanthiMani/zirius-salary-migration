package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "company_free_car_insurance", schema = "salary")
@Data
public class CompanyFreeCarInsuranceObject {

    @Id
    @Column(name = "COMPANY_FREE_CAR_INSURANCE_ID")
    private Integer companyFreeCarInsuranceId;

    @Column(name = "INSURANCE_DATE")
    private Date insuranceDate;

    @Column(name = "DISTANCE_TRAVELLED_TILL")
    private Integer distanceTravelledTill;

    @Column(name = "DISTANCE_TRAVELLED_PER_YEAR")
    private Integer distanceTravelledPerYear;

    @Column(name = "DEDUCTABLE")
    private BigDecimal deductable;

    @Column(name = "CORPORTATION")
    private String corportation;

    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_DATETIME")
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    private Date modifiedDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;
}
