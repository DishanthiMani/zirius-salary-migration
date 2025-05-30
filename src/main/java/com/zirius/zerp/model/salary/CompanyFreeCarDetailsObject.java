package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "company_free_car_details")
@Data
public class CompanyFreeCarDetailsObject {

    @Id
    @Column(name = "COMPANY_FREE_CAR_DETAILS_ID")
    private Integer companyFreeCarDetailsId;

    @Column(name = "REGISTER_NO")
    private String registerNo;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "REGISTERED_DATE")
    
    private Date registeredDate;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "LIST_PRICE")
    private BigDecimal listPrice;

    @Column(name = "COMPANY_FREE_CAR_SETTINGS_ID")
    private Integer companyFreeCarSettingsId;

    @Column(name = "COMPANY_FREE_CAR_BENEFITS_ID")
    private Integer companyFreeCarBenefitsId;

    @Column(name = "COMPANY_FREE_CAR_INSURANCE_ID")
    private Integer companyFreeCarInsuranceId;

    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "MODIFIED_DATETIME")
    private Date modifiedDatetime;

    @Column(name = "CREATED_DATETIME")
    private Date createdDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;

    
}
