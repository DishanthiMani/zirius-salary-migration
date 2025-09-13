package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "company_salary_details", schema = "salary")
@Data
public class CompanySalaryDetailsObject {

    public static final String PROPERTYNAME_companyId = "COMPANY_ID";
    public static final String PROPERTYNAME_municipalityId = "MUNICIPALITY_ID";
    public static final String PROPERTYNAME_changedSalaryDetails = "CHANGED_SALARY_DETAILS";
    public static final String PROPERTYNAME_naceCode = "NACE_CODE";
    public static final String PROPERTYNAME_isPensionScheme = "IS_PENSION_SCHEME";
    public static final String PROPERTYNAME_pensionProvider = "PENSION_PROVIDER";
    public static final String PROPERTYNAME_companyOrganizationTypeId = "COMPANY_ORGANIZATION_TYPE_ID";
    public static final String PROPERTYNAME_isFinancialDifficultyEnabled = "IS_FINANCIAL_DIFFICULTY_ENABLED";
    public static final String PROPERTYNAME_activeFinancialDifficultyStartMonth = "ACTIVE_FINANCIAL_DIFFICULTY_START_MONTH";
    public static final String PROPERTYNAME_activeFinancialDifficultyEndMonth = "ACTIVE_FINANCIAL_DIFFICULTY_END_MONTH";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_createdDatetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modifiedDatetime = "MODIFIED_DATETIME";

    @Id
    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "MUNICIPALITY_ID")
    private Integer municipalityId;

    @Column(name = "CHANGED_SALARY_DETAILS")
    private Date changedSalaryDetails;

    @Column(name = "NACE_CODE")
    private String naceCode;

    @Column(name = "IS_PENSION_SCHEME")
    private Boolean isPensionScheme;

    @Column(name = "PENSION_PROVIDER")
    private String pensionProvider;

    @Column(name = "COMPANY_ORGANIZATION_TYPE_ID")
    private Integer companyOrganizationTypeId;

    @Column(name = "IS_FINANCIAL_DIFFICULTY_ENABLED")
    private Boolean isFinancialDifficultyEnabled;

    @Column(name = "ACTIVE_FINANCIAL_DIFFICULTY_START_MONTH")
    private Integer activeFinancialDifficultyStartMonth;

    @Column(name = "ACTIVE_FINANCIAL_DIFFICULTY_END_MONTH")
    private Integer activeFinancialDifficultyEndMonth;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_DATETIME")
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    private Date modifiedDatetime;

}
