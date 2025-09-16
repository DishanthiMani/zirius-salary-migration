package com.zirius.zerp.model.salary;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employee_startup_details", schema = "salary")
public class EmployeeStartUpDetailsObject {

    public static final String PROPERTYNAME_employee_startup_details_id = "employee_startup_details_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_total_salary = "total_salary";
    public static final String PROPERTYNAME_total_person_tax = "total_person_tax";
    public static final String PROPERTYNAME_person_tax_year = "person_tax_year";
    public static final String PROPERTYNAME_total_company_tax = "total_company_tax";
    public static final String PROPERTYNAME_total_holiday_pay = "total_holiday_pay";
    public static final String PROPERTYNAME_holiday_pay_year = "holiday_pay_year";
    public static final String PROPERTYNAME_available_holidays = "available_holidays";
    public static final String PROPERTYNAME_basis_person = "basis_person";
    public static final String PROPERTYNAME_basis_company = "basis_company";
    public static final String PROPERTYNAME_basis_holiday_pay = "basis_holiday_pay";
    public static final String PROPERTYNAME_basis_holiday_pay_tax = "basis_holiday_pay_tax";
    public static final String PROPERTYNAME_deviant_holiday_pay_balance = "deviant_holiday_pay_balance";
    public static final String PROPERTYNAME_deviant_holiday_percent = "deviant_holiday_percent";
    public static final String PROPERTYNAME_basis_holiday_pay_over_60 = "basis_holiday_pay_over_60";
    public static final String PROPERTYNAME_basis_holiday_pay_over_60_tax = "basis_holiday_pay_over_60_tax";
    public static final String PROPERTYNAME_remaining_holiday_pay_amount = "remaining_holiday_pay_amount";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_is_active = "is_active";
    public static final String PROPERTYNAME_employee_id = "employee_id";
    
    @Id
    private int employee_startup_details_id;
    private int company_id=0;
    
    private BigDecimal total_salary = new BigDecimal("0");
    
    private BigDecimal total_person_tax = new BigDecimal("0");
    private int person_tax_year;
    
    private BigDecimal total_company_tax = new BigDecimal("0");
    
    private BigDecimal total_holiday_pay = new BigDecimal("0");
    private int holiday_pay_year;
    
    private BigDecimal available_holidays = new BigDecimal("0");
    
    private BigDecimal basis_person = new BigDecimal("0");
    
    private BigDecimal basis_company = new BigDecimal("0");
    
    private BigDecimal basis_holiday_pay = new BigDecimal("0");
    
    private BigDecimal basis_holiday_pay_tax = new BigDecimal("0");
    
    private BigDecimal deviant_holiday_pay_balance = new BigDecimal("0");
    
    private BigDecimal deviant_holiday_percent = new BigDecimal("0");
    
    private BigDecimal basis_holiday_pay_over_60 = new BigDecimal("0");
    
    private BigDecimal basis_holiday_pay_over_60_tax = new BigDecimal("0");

    private BigDecimal remaining_holiday_pay_amount = new BigDecimal("0");
    private int version=0;
    private LocalDateTime modified_datetime ;
    private LocalDateTime created_datetime ;
    private boolean is_active;
    private String employee_id;
}

