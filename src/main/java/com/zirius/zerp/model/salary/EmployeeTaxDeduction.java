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
@Table(name = "employee_tax_deduction", schema = "salary")
public class EmployeeTaxDeduction {

    public static final String PROPERTYNAME_ssn_type_id = "ssn_type_id";
    public static final String PROPERTYNAME_employee_number = "employee_number";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_ssn = "ssn";
    public static final String PROPERTYNAME_international_id = "international_id";
    public static final String PROPERTYNAME_is_foreign_earning_country = "is_foreign_earning_country";
    public static final String PROPERTYNAME_foreign_country_code = "foreign_country_code";
    public static final String PROPERTYNAME_is_continental_shelf = "is_continental_shelf";
    public static final String PROPERTYNAME_is_border_worker = "is_border_worker";
    public static final String PROPERTYNAME_border_worker_country_code = "border_worker_country_code";
    public static final String PROPERTYNAME_employee_number_type_id = "employee_number_type_id";
    public static final String PROPERTYNAME_international_type_id = "international_type_id";
    public static final String PROPERTYNAME_date_of_birth = "date_of_birth";
    public static final String PROPERTYNAME_municipality_id = "municipality_id";
    public static final String PROPERTYNAME_foreigner_id = "foreigner_id";
    public static final String PROPERTYNAME_table_type_id = "table_type_id";
    public static final String PROPERTYNAME_table_number = "table_number";
    public static final String PROPERTYNAME_percentage_draw_id = "percentage_draw_id";
    public static final String PROPERTYNAME_is_more_than_one_employer = "is_more_than_one_employer";
    public static final String PROPERTYNAME_is_pensioner = "is_pensioner";
    public static final String PROPERTYNAME_free_card_amount = "free_card_amount";
    public static final String PROPERTYNAME_free_card_balance = "free_card_balance";
    public static final String PROPERTYNAME_number_of_weeks = "number_of_weeks";
    public static final String PROPERTYNAME_sailors_id = "sailors_id";
    public static final String PROPERTYNAME_tax_rule_id = "tax_rule_id";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_tax_card_date = "tax_card_date";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";

    @Id
    private String employee_id;
    private int ssn_type_id=0;
    private int employee_number=0;
    private int company_id=0;
    private String ssn;
    private String international_id;
    private boolean is_foreign_earning_country;
    private String foreign_country_code;
    private boolean is_continental_shelf;
    private boolean is_border_worker;
    private String border_worker_country_code;
    private int employee_number_type_id;
    private int international_type_id;
    private LocalDate date_of_birth= null;
    private int municipality_id;
    private int foreigner_id;
    private int table_type_id;
    private int table_number;
    private BigDecimal percentage_draw_id = new BigDecimal("0");
    private boolean is_more_than_one_employer;
    private boolean is_pensioner;
    private BigDecimal free_card_amount = new BigDecimal("0");
    private BigDecimal free_card_balance = new BigDecimal("0");
    private int number_of_weeks;
    private int sailors_id;
    private int tax_rule_id;
    private int version=0;
    private LocalDate tax_card_date= null;
    private LocalDateTime created_datetime;
    private LocalDateTime modified_datetime;

}
