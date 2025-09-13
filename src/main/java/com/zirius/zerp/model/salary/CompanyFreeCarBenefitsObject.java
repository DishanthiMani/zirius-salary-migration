package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "company_free_car_benefits", schema = "salary")
@Data
public class CompanyFreeCarBenefitsObject {

    @Id
    @Column(name = "COMPANY_FREE_CAR_BENEFITS_ID")
    private Integer companyFreeCarBenefitsId;

    @Column(name = "SALARY_REPORTING_CODE_ID")
    private Integer salaryReportingCodeId;

    @Column(name = "ANNUAL_BENEFIT")
    private BigDecimal annualBenefit;

    @Column(name = "AMOUNT_PER_SETTLEMENT")
    private BigDecimal amountPerSettlement;

    @Column(name = "PRICE")
    private BigDecimal price;

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
