package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salary_yearly_constants_config", schema = "salary")
@Data
public class SalaryYearlyConstantsConfigObject {

    public static final String PROPERTYNAME_yearlyConstantsId = "YEARLY_CONSTANTS_ID";
    public static final String PROPERTYNAME_maxEcomRefundAmount = "MAX_ECOM_REFUND_AMOUNT";
    public static final String PROPERTYNAME_carAllowanceWithTax = "CAR_ALLOWANCE_WITH_TAX";
    public static final String PROPERTYNAME_carAllowanceWithoutTax = "CAR_ALLOWANCE_WITHOUT_TAX";
    public static final String PROPERTYNAME_carAllowanceOverLimit = "CAR_ALLOWANCE_OVER_LIMIT";
    public static final String PROPERTYNAME_electricCarAllowanceWithTax = "ELECTRIC_CAR_ALLOWANCE_WITH_TAX";
    public static final String PROPERTYNAME_electricCarAllowanceWithoutTax = "ELECTRIC_CAR_ALLOWANCE_WITHOUT_TAX";
    public static final String PROPERTYNAME_electricCarAllowanceOverLimit = "ELECTRIC_CAR_ALLOWANCE_OVER_LIMIT";
    public static final String PROPERTYNAME_kilometerTrailer = "KILOMETER_TRAILER";
    public static final String PROPERTYNAME_passengerAddition = "PASSENGER_ADDITION";
    public static final String PROPERTYNAME_forestAndConstructionWay = "FOREST_AND_CONSTRUCTION_WAY";
    public static final String PROPERTYNAME_toolAllowanceForConstructionWorkersWithoutTax = "TOOL_ALLOWANCE_FOR_CONSTRUCTION_WORKERS_WITHOUT_TAX";
    public static final String PROPERTYNAME_toolAllowanceForForestWorkers = "TOOL_ALLOWANCE_FOR_FOREST_WORKERS";
    public static final String PROPERTYNAME_freeCarBaseValue = "FREE_CAR_BASE_VALUE";
    public static final String PROPERTYNAME_holidayPayOver60Yrs = "HOLIDAY_PAY_OVER_60_YRS";
    public static final String PROPERTYNAME_oneGYearlyConstant = "ONE_G_YEARLY_CONSTANT";
    public static final String PROPERTYNAME_year = "YEAR";
    public static final String PROPERTYNAME_companyId = "COMPANY_ID";
    public static final String PROPERTYNAME_salaryCodeConstant = "SALARY_CODE_CONSTANT";
    public static final String PROPERTYNAME_paulArbAvgOfBonusAmountConstant = "PAUL_ARB_AVG_OF_BONUS_AMOUNT_CONSTANT";
    public static final String PROPERTYNAME_holidayPayAmountConstant = "HOLIDAY_PAY_AMOUNT_CONSTANT";
    public static final String PROPERTYNAME_maxFreeCardAmount = "MAX_FREE_CARD_AMOUNT";
    public static final String PROPERTYNAME_transportMaxFreeCardAmount = "TRANSPORT_MAX_FREE_CARD_AMOUNT";
    public static final String PROPERTYNAME_companyTaxPercent = "COMPANY_TAX_PERCENT";
    public static final String PROPERTYNAME_additionalCompanyTaxLimit = "ADDITIONAL_COMPANY_TAX_LIMIT";
    public static final String PROPERTYNAME_additionalCompanyTaxPercent = "ADDITIONAL_COMPANY_TAX_PERCENT";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_isActive = "IS_ACTIVE";
    public static final String PROPERTYNAME_createdDatetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modifiedDatetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_toBeDeleted = "TO_BE_DELETED";
    public static final String PROPERTYNAME_limitToSixG = "LIMIT_TO_SIX_G";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "YEARLY_CONSTANTS_ID")
    private Integer yearlyConstantsId;

    @Column(name = "MAX_ECOM_REFUND_AMOUNT")
    private BigDecimal maxEcomRefundAmount;

    @Column(name = "CAR_ALLOWANCE_WITH_TAX")
    private BigDecimal carAllowanceWithTax;

    @Column(name = "CAR_ALLOWANCE_WITHOUT_TAX")
    private BigDecimal carAllowanceWithoutTax;

    @Column(name = "CAR_ALLOWANCE_OVER_LIMIT")
    private BigDecimal carAllowanceOverLimit;

    @Column(name = "ELECTRIC_CAR_ALLOWANCE_WITH_TAX")
    private BigDecimal electricCarAllowanceWithTax;

    @Column(name = "ELECTRIC_CAR_ALLOWANCE_WITHOUT_TAX")
    private BigDecimal electricCarAllowanceWithoutTax;

    @Column(name = "ELECTRIC_CAR_ALLOWANCE_OVER_LIMIT")
    private BigDecimal electricCarAllowanceOverLimit;

    @Column(name = "KILOMETER_TRAILER")
    private BigDecimal kilometerTrailer;

    @Column(name = "PASSENGER_ADDITION")
    private BigDecimal passengerAddition;

    @Column(name = "FOREST_AND_CONSTRUCTION_WAY")
    private BigDecimal forestAndConstructionWay;

    @Column(name = "TOOL_ALLOWANCE_FOR_CONSTRUCTION_WORKERS_WITHOUT_TAX")
    private BigDecimal toolAllowanceForConstructionWorkersWithoutTax;

    @Column(name = "TOOL_ALLOWANCE_FOR_FOREST_WORKERS")
    private BigDecimal toolAllowanceForForestWorkers;

    @Column(name = "FREE_CAR_BASE_VALUE")
    private BigDecimal freeCarBaseValue;

    @Column(name = "HOLIDAY_PAY_OVER_60_YRS")
    private BigDecimal holidayPayOver60Yrs;

    @Column(name = "ONE_G_YEARLY_CONSTANT")
    private BigDecimal oneGYearlyConstant;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "SALARY_CODE_CONSTANT")
    private BigDecimal salaryCodeConstant;

    @Column(name = "PAUL_ARB_AVG_OF_BONUS_AMOUNT_CONSTANT")
    private BigDecimal paulArbAvgOfBonusAmountConstant;

    @Column(name = "HOLIDAY_PAY_AMOUNT_CONSTANT")
    private BigDecimal holidayPayAmountConstant;

    @Column(name = "MAX_FREE_CARD_AMOUNT")
    private BigDecimal maxFreeCardAmount;

    @Column(name = "TRANSPORT_MAX_FREE_CARD_AMOUNT")
    private BigDecimal transportMaxFreeCardAmount;

    @Column(name = "COMPANY_TAX_PERCENT")
    private BigDecimal companyTaxPercent;

    @Column(name = "ADDITIONAL_COMPANY_TAX_LIMIT")
    private Integer additionalCompanyTaxLimit;

    @Column(name = "ADDITIONAL_COMPANY_TAX_PERCENT")
    private BigDecimal additionalCompanyTaxPercent;

    @Column(name = "VERSION", nullable = false)
    private Integer version;

    @Column(name = "IS_ACTIVE", nullable = false)
    private Boolean isActive = true;

    @Column(name = "CREATED_DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive = false;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted = false;

    @Column(name = "LIMIT_TO_SIX_G")
    private Boolean limitToSixG = false;
}
