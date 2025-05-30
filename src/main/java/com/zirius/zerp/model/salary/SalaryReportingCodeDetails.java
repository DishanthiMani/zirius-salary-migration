package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "salary_reporting_code_details")
public class SalaryReportingCodeDetails {

    @Id
    @Column(name = "SALARY_REPORTING_CODE_ID")
    private Integer salaryReportingCodeId;

    @Id
    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "SALARY_REPORTING_CODE")
    private String salaryReportingCode;

    @Column(name = "SALARY_REPORTING_CODE_NAME")
    private String salaryReportingCodeName;

    @Column(name = "DEBIT_ACCOUNT_NO")
    private Integer debitAccountNo;

    @Column(name = "CREDIT_ACCOUNT_NO")
    private Integer creditAccountNo;

    @Column(name = "SALARY_TYPE_ID")
    private Integer salaryTypeId;

    @Column(name = "COST_PRICE")
    private BigDecimal costPrice;

    @Column(name = "SALE_PRICE")
    private BigDecimal salePrice;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "SALARY_DESCRIPTION")
    private Integer salaryDescription;

    @Column(name = "BENEFITS")
    private Integer benefits;

    @Column(name = "IS_SPECIFICATION")
    private Boolean isSpecification;

    @Column(name = "IS_HOLIDAY_PAY")
    private Boolean isHolidayPay;

    @Column(name = "IS_PAYROLL_TAX")
    private Boolean isPayrollTax;

    @Column(name = "IS_UNION")
    private Boolean isUnion;

    @Column(name = "TAXES_ID")
    private Integer taxesId;

    @Column(name = "PENSION_ID")
    private Integer pensionId;

    @Column(name = "SSB_ID")
    private Integer ssbId;

    @Column(name = "IS_PENSION")
    private Boolean isPension;

    @Column(name = "SALARY_CODE_RATE_TYPE_ID")
    private Integer salaryCodeRateTypeId;

    @Column(name = "SALARY_CODE_YEARLY_RATE_TYPE_ID")
    private Integer salaryCodeYearlyRateTypeId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_DATETIME")
    private LocalDateTime createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    private LocalDateTime modifiedDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;

}
