package com.zirius.zerp.model.salary;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "user_company_salary_config", schema = "salary")
public class EmployeeSalaryConfig {

    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_salary_group_id = "salary_group_id";
    public static final String PROPERTYNAME_annual_salary = "annual_salary";
    public static final String PROPERTYNAME_work_percentage = "work_percentage";
    public static final String PROPERTYNAME_fixed_salary = "fixed_salary";
    public static final String PROPERTYNAME_salary_per_hour = "salary_per_hour";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";

    @Id
    private String employee_id;
    private int company_id=0;
    private int salary_group_id;
    private BigDecimal annual_salary = new BigDecimal("0");
    private BigDecimal work_percentage = new BigDecimal("0");
    private BigDecimal fixed_salary = new BigDecimal("0");
    private BigDecimal salary_per_hour = new BigDecimal("0");
    private int version=0;
    private LocalDateTime created_datetime ;
    private LocalDateTime modified_datetime ;
}

