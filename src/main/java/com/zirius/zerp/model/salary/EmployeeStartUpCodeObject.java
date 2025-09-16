package com.zirius.zerp.model.salary;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employee_startup_salary_codes", schema = "salary")
public class EmployeeStartUpCodeObject {

    public static final String PROPERTYNAME_claim_collectors_id = "claim_collectors_id";
    public static final String PROPERTYNAME_employee_startup_salary_code_id = "employee_startup_salary_code_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_user_company_free_car_details_id = "user_company_free_car_details_id";
    public static final String PROPERTYNAME_company_free_car_details_id = "company_free_car_details_id";
    public static final String PROPERTYNAME_free_car_start_date = "free_car_start_date";
    public static final String PROPERTYNAME_free_car_end_date = "free_car_end_date";
    public static final String PROPERTYNAME_user_company_claim_collector_config_id = "user_company_claim_collector_config_id";
    public static final String PROPERTYNAME_reference_year = "reference_year";
    public static final String PROPERTYNAME_salary_reporting_code_id = "salary_reporting_code_id";
    public static final String PROPERTYNAME_salary_reporting_code = "salary_reporting_code";
    public static final String PROPERTYNAME_salary_reporting_code_name = "salary_reporting_code_name";
    public static final String PROPERTYNAME_description = "description";
    public static final String PROPERTYNAME_count = "count";
    public static final String PROPERTYNAME_rate = "rate";
    public static final String PROPERTYNAME_amount = "amount";
    public static final String PROPERTYNAME_sick_refund_year = "sick_refund_year";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_employee_startup_details_id = "employee_startup_details_id";
    public static final String PROPERTYNAME_work_place_id = "work_place_id";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";
    public static final String PROPERTYNAME_inactive = "inactive";
    public static final String PROPERTYNAME_to_be_deleted = "to_be_deleted";
    
    @Id
    private int claim_collectors_id=0;
    private int employee_startup_salary_code_id;
    private int company_id=0;
    private int user_company_free_car_details_id;
    private int company_free_car_details_id;
    private LocalDate free_car_start_date= null;
    private LocalDate free_car_end_date= null;
    private int user_company_claim_collector_config_id;
    
    private String reference_year;
    private int salary_reporting_code_id;
    
    private String salary_reporting_code;
    
    private String salary_reporting_code_name;
   
    private String description;
    
    private BigDecimal count = new BigDecimal("0");
    
    private BigDecimal rate = new BigDecimal("0");
    
    private BigDecimal amount = new BigDecimal("0");

    private String sick_refund_year;
    private int version=0;
    private int employee_startup_details_id;
    private int work_place_id;
    private LocalDateTime created_datetime ;
    private LocalDateTime modified_datetime ;

    private String employee_id;
    private boolean inactive;
    private boolean to_be_deleted;
}

