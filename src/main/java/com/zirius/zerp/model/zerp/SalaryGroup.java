package com.zirius.zerp.model.zerp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Date;

// @Entity
// @Table(name = "salary_group")
public class SalaryGroup {


    private Integer SALARY_GROUP_ID;

    private Integer SALARY_GROUP_NO;

    private String SALARY_GROUP_NAME;

    private Integer DEPARTMENT_ID;

    private Integer SALARY_GROUP_PAYROLL_PER_YEAR;

    private BigDecimal SALARY_GROUP_HOURS1;

    private BigDecimal SALARY_GROUP_HOURS2;

    private BigDecimal SALARY_GROUP_HOURS3;

    private BigDecimal SALARY_GROUP_HOURS4;

    private BigDecimal SALARY_GROUP_HOURS5;

    private BigDecimal SALARY_GROUP_HOURS_FTE;

    private Date SALARY_GROUP_LPA_DATE;

    private Integer SALARY_GROUP_CALENDAR_TEMPLATE;

    private Boolean IS_REPORTING_SICKNESS;

    private Boolean IS_ACTIVE;

    private Boolean IS_DELETED = Boolean.FALSE;

    private Integer VERSION;

    private Date CREATED_DATETIME;

    private Date MODIFIED_DATETIME;

    private Integer COMPANY_ID;

    private Boolean DEVIANT_HOLIDAY_PAY_PERCENT;

    private BigDecimal HOLIDAY_PAY_PERCENT;

    private Integer HOLIDAY_PERCENT_UPDATED_DATE;

    private BigDecimal HOLIDAY_PAY_PERCENT_OVER_60;

    private BigDecimal HOURS_PER_DAY;

    public Integer getSALARY_GROUP_ID() {
        return SALARY_GROUP_ID;
    }

    public void setSALARY_GROUP_ID(Integer SALARY_GROUP_ID) {
        this.SALARY_GROUP_ID = SALARY_GROUP_ID;
    }

    public String getSALARY_GROUP_NAME() {
        return SALARY_GROUP_NAME;
    }

    public void setSALARY_GROUP_NAME(String SALARY_GROUP_NAME) {
        this.SALARY_GROUP_NAME = SALARY_GROUP_NAME;
    }

    public Integer getDepartmentId() {
        return DEPARTMENT_ID;
    }

    public void setDepartmentId(Integer departmentId) {
        this.DEPARTMENT_ID = departmentId;
    }

    public Integer getSALARY_GROUP_PAYROLL_PER_YEAR() {
        return SALARY_GROUP_PAYROLL_PER_YEAR;
    }

    public void setSALARY_GROUP_PAYROLL_PER_YEAR(Integer salaryGroupPayrollPerYear2) {
        this.SALARY_GROUP_PAYROLL_PER_YEAR = salaryGroupPayrollPerYear2;
    }

    public BigDecimal getSALARY_GROUP_HOURS1() {
        return SALARY_GROUP_HOURS1;
    }

    public void setSALARY_GROUP_HOURS1(BigDecimal SALARY_GROUP_HOURS1) {
        this.SALARY_GROUP_HOURS1 = SALARY_GROUP_HOURS1;
    }

    public BigDecimal getSALARY_GROUP_HOURS2() {
        return SALARY_GROUP_HOURS2;
    }

    public void setSALARY_GROUP_HOURS2(BigDecimal SALARY_GROUP_HOURS2) {
        this.SALARY_GROUP_HOURS2 = SALARY_GROUP_HOURS2;
    }

    public BigDecimal getSALARY_GROUP_HOURS3() {
        return SALARY_GROUP_HOURS3;
    }

    public void setSALARY_GROUP_HOURS3(BigDecimal SALARY_GROUP_HOURS3) {
        this.SALARY_GROUP_HOURS3 = SALARY_GROUP_HOURS3;
    }

    public BigDecimal getSALARY_GROUP_HOURS4() {
        return SALARY_GROUP_HOURS4;
    }

    public void setSALARY_GROUP_HOURS4(BigDecimal SALARY_GROUP_HOURS4) {
        this.SALARY_GROUP_HOURS4 = SALARY_GROUP_HOURS4;
    }

    public BigDecimal getSALARY_GROUP_HOURS5() {
        return SALARY_GROUP_HOURS5;
    }

    public void setSALARY_GROUP_HOURS5(BigDecimal SALARY_GROUP_HOURS5) {
        this.SALARY_GROUP_HOURS5 = SALARY_GROUP_HOURS5;
    }

    public BigDecimal getSALARY_GROUP_HOURS_FTE() {
        return SALARY_GROUP_HOURS_FTE;
    }

    public void setSALARY_GROUP_HOURS_FTE(BigDecimal SALARY_GROUP_HOURS_FTE) {
        this.SALARY_GROUP_HOURS_FTE = SALARY_GROUP_HOURS_FTE;
    }

    public Date getSALARY_GROUP_LPA_DATE() {
        return SALARY_GROUP_LPA_DATE;
    }

    public void setSALARY_GROUP_LPA_DATE(Date SALARY_GROUP_LPA_DATE) {
        this.SALARY_GROUP_LPA_DATE = SALARY_GROUP_LPA_DATE;
    }

    public Integer getSALARY_GROUP_CALENDAR_TEMPLATE() {
        return SALARY_GROUP_CALENDAR_TEMPLATE;
    }

    public void setSALARY_GROUP_CALENDAR_TEMPLATE(Integer SALARY_GROUP_CALENDAR_TEMPLATE) {
        this.SALARY_GROUP_CALENDAR_TEMPLATE = SALARY_GROUP_CALENDAR_TEMPLATE;
    }

    public Boolean getIS_REPORTING_SICKNESS() {
        return IS_REPORTING_SICKNESS;
    }

    public void setIS_REPORTING_SICKNESS(Boolean IS_REPORTING_SICKNESS) {
        this.IS_REPORTING_SICKNESS = IS_REPORTING_SICKNESS;
    }

    public Boolean getIsActive() {
        return IS_ACTIVE;
    }

    public void setIsActive(Boolean isActive) {
        this.IS_ACTIVE = isActive;
    }

    public Boolean getIS_DELETED() {
        return IS_DELETED;
    }

    public void setIS_DELETED(Boolean IS_DELETED) {
        this.IS_DELETED = IS_DELETED;
    }

    public Integer getVersion() {
        return VERSION;
    }

    public void setVersion(Integer version) {
        this.VERSION = version;
    }

    public Date getCREATED_DATETIME() {
        return CREATED_DATETIME;
    }

    public void setCREATED_DATETIME(Date CREATED_DATETIME) {
        this.CREATED_DATETIME = CREATED_DATETIME;
    }

    public Date getModifiedDateTime() {
        return MODIFIED_DATETIME;
    }

    public void setModifiedDateTime(Date modifiedDateTime) {
        this.MODIFIED_DATETIME = modifiedDateTime;
    }

    public Integer getCOMPANY_ID() {
        return COMPANY_ID;
    }

    public void setCOMPANY_ID(Integer COMPANY_ID) {
        this.COMPANY_ID = COMPANY_ID;
    }

    public Boolean getDEVIANT_HOLIDAY_PAY_PERCENT() {
        return DEVIANT_HOLIDAY_PAY_PERCENT;
    }

    public void setDEVIANT_HOLIDAY_PAY_PERCENT(Boolean DEVIANT_HOLIDAY_PAY_PERCENT) {
        this.DEVIANT_HOLIDAY_PAY_PERCENT = DEVIANT_HOLIDAY_PAY_PERCENT;
    }

    public BigDecimal getHolidayPayPercent() {
        return HOLIDAY_PAY_PERCENT;
    }

    public void setHolidayPayPercent(BigDecimal holidayPayPercent) {
        this.HOLIDAY_PAY_PERCENT = holidayPayPercent;
    }

    public BigDecimal getHolidayPayPercentOver60() {
        return HOLIDAY_PAY_PERCENT_OVER_60;
    }

    public void setHolidayPayPercentOver60(BigDecimal holidayPayPercentOver60) {
        this.HOLIDAY_PAY_PERCENT_OVER_60 = holidayPayPercentOver60;
    }

    public Integer getSALARY_GROUP_NO() {
        return SALARY_GROUP_NO;
    }

    public void setSALARY_GROUP_NO(Integer SALARY_GROUP_NO) {
        this.SALARY_GROUP_NO = SALARY_GROUP_NO;
    }

    public BigDecimal getHOURS_PER_DAY() {
        return HOURS_PER_DAY;
    }

    public void setHOURS_PER_DAY(BigDecimal HOURS_PER_DAY) {
        this.HOURS_PER_DAY = HOURS_PER_DAY;
    }

    public Integer getId() {
        return this.SALARY_GROUP_ID;
    }

    public Integer getHOLIDAY_PERCENT_UPDATED_DATE() {
        return HOLIDAY_PERCENT_UPDATED_DATE;
    }

    public void setHOLIDAY_PERCENT_UPDATED_DATE(Integer HOLIDAY_PERCENT_UPDATED_DATE) {
        this.HOLIDAY_PERCENT_UPDATED_DATE = HOLIDAY_PERCENT_UPDATED_DATE;
    }
}
