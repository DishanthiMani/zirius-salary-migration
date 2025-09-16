package com.zirius.zerp.model.salary;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "salary_employee_taxdetails", schema = "salary")
public class SalaryEmployeeTaxDetails {

    public static final String PROPERTYNAME_salary_employee_taxdetails_id = "salary_employee_taxdetails_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_salary_taxinfo_id = "salary_taxinfo_id";
    public static final String PROPERTYNAME_user_ssn = "user_ssn";
    public static final String PROPERTYNAME_org_no = "org_no";
    public static final String PROPERTYNAME_municipality = "municipality";
    public static final String PROPERTYNAME_table_no = "table_no";
    public static final String PROPERTYNAME_table_type = "table_type";
    public static final String PROPERTYNAME_percentage = "percentage";
    public static final String PROPERTYNAME_advance_form = "advance_form";
    public static final String PROPERTYNAME_employee_group = "employee_group";
    public static final String PROPERTYNAME_signal_flag = "signal_flag";
    public static final String PROPERTYNAME_old_start_date = "old_start_date";
    public static final String PROPERTYNAME_start_date = "start_date";
    public static final String PROPERTYNAME_exception_card_amounts = "exception_card_amounts";
    public static final String PROPERTYNAME_table_card_flag = "table_card_flag";
    public static final String PROPERTYNAME_tax_card_id = "tax_card_id";
    public static final String PROPERTYNAME_income_year = "income_year";
    public static final String PROPERTYNAME_additional_info = "additional_info";
    
    
    @Id
    private int salary_employee_taxdetails_id;
    private int company_id=0;
    private int salary_taxinfo_id;
    
    private String user_ssn;
    
    private String org_no;
    
    private String municipality;
    
    private String table_no;
    
    private String table_type;
    
    private String percentage;
    
    private String advance_form;
    
    private String employee_group;
    
    private String signal_flag;
    
    private String old_start_date;
    private LocalDateTime start_date ;
    
    private String exception_card_amounts;
    
    private String table_card_flag;
    
    private String tax_card_id;
    private int income_year;
    
    private String additional_info;
}

