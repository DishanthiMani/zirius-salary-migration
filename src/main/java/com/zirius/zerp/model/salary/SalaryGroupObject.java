package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "salary_group", schema = "salary")
@Data
public class SalaryGroupObject {

    public static final String PROPERTYNAME_salaryGroupId = "SALARY_GROUP_ID";
    public static final String PROPERTYNAME_companyId = "COMPANY_ID";
    public static final String PROPERTYNAME_salaryGroupNo = "SALARY_GROUP_NO";
    public static final String PROPERTYNAME_salaryGroupName = "SALARY_GROUP_NAME";
    public static final String PROPERTYNAME_departmentId = "DEPARTMENT_ID";
    public static final String PROPERTYNAME_salaryGroupPayrollPerYear = "SALARY_GROUP_PAYROLL_PER_YEAR";
    public static final String PROPERTYNAME_salaryGroupHours1 = "SALARY_GROUP_HOURS1";
    public static final String PROPERTYNAME_salaryGroupHours2 = "SALARY_GROUP_HOURS2";
    public static final String PROPERTYNAME_salaryGroupHours3 = "SALARY_GROUP_HOURS3";
    public static final String PROPERTYNAME_salaryGroupHours4 = "SALARY_GROUP_HOURS4";
    public static final String PROPERTYNAME_salaryGroupHours5 = "SALARY_GROUP_HOURS5";
    public static final String PROPERTYNAME_salaryGroupHoursFte = "SALARY_GROUP_HOURS_FTE";
    public static final String PROPERTYNAME_salaryGroupLpaDate = "SALARY_GROUP_LPA_DATE";
    public static final String PROPERTYNAME_deviantHolidayPayPercent = "DEVIANT_HOLIDAY_PAY_PERCENT";
    public static final String PROPERTYNAME_holidayPayPercent = "HOLIDAY_PAY_PERCENT";
    public static final String PROPERTYNAME_holidayPercentUpdatedDate = "HOLIDAY_PERCENT_UPDATED_DATE";
    public static final String PROPERTYNAME_holidayPayPercentOver60 = "HOLIDAY_PAY_PERCENT_OVER_60";
    public static final String PROPERTYNAME_salaryGroupCalendarTemplate = "SALARY_GROUP_CALENDAR_TEMPLATE";
    public static final String PROPERTYNAME_isReportingSickness = "IS_REPORTING_SICKNESS";
    public static final String PROPERTYNAME_isActive = "IS_ACTIVE";
    public static final String PROPERTYNAME_isDeleted = "IS_DELETED";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_createdDatetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modifiedDatetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_hoursPerDay = "HOURS_PER_DAY";
    public static final String PROPERTYNAME_salaryGroupType = "SALARY_GROUP_TYPE";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_toBeDeleted = "TO_BE_DELETED";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALARY_GROUP_ID")
    private Integer salaryGroupId;


    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "SALARY_GROUP_NO")
    private Integer salaryGroupNo;

    @Column(name = "SALARY_GROUP_NAME")
    private String salaryGroupName;

    @Column(name = "DEPARTMENT_ID")
    private Integer departmentId;

    @Column(name = "SALARY_GROUP_PAYROLL_PER_YEAR")
    private Integer salaryGroupPayrollPerYear;

    @Column(name = "SALARY_GROUP_HOURS1")
    private BigDecimal salaryGroupHours1;

    @Column(name = "SALARY_GROUP_HOURS2")
    private BigDecimal salaryGroupHours2;

    @Column(name = "SALARY_GROUP_HOURS3")
    private BigDecimal salaryGroupHours3;

    @Column(name = "SALARY_GROUP_HOURS4")
    private BigDecimal salaryGroupHours4;

    @Column(name = "SALARY_GROUP_HOURS5")
    private BigDecimal salaryGroupHours5;

    @Column(name = "SALARY_GROUP_HOURS_FTE")
    private BigDecimal salaryGroupHoursFte;

    @Column(name = "SALARY_GROUP_LPA_DATE")
    private Date salaryGroupLpaDate;

    @Column(name = "DEVIANT_HOLIDAY_PAY_PERCENT")
    private Boolean deviantHolidayPayPercent;

    @Column(name = "HOLIDAY_PAY_PERCENT")
    private BigDecimal holidayPayPercent;

    @Column(name = "HOLIDAY_PERCENT_UPDATED_DATE")
    private Integer holidayPercentUpdatedDate;

    @Column(name = "HOLIDAY_PAY_PERCENT_OVER_60")
    private BigDecimal holidayPayPercentOver60;

    @Column(name = "SALARY_GROUP_CALENDAR_TEMPLATE")
    private Integer salaryGroupCalendarTemplate;

    @Column(name = "IS_REPORTING_SICKNESS")
    private Boolean isReportingSickness;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "IS_DELETED")
    private Boolean isDeleted;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDatetime;

    @Column(name = "HOURS_PER_DAY")
    private BigDecimal hoursPerDay;

    @Column(name = "SALARY_GROUP_TYPE")
    private Integer salaryGroupType;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;

}
