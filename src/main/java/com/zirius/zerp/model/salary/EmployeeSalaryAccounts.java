package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Data
@Table(name = "employee_salary_accounts", schema = "salary")
public class EmployeeSalaryAccounts {

    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_bank_account_id = "bank_account_id";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";

    @Id
    private int company_id=0;
    private int bank_account_id;
    private int version=0;
    private LocalDateTime created_datetime ;
    private LocalDateTime modified_datetime ;
    private String employee_id;

}

