package com.zirius.zerp.model.salary;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employee_permission", schema = "salary")
public class EmployeePermissionObject {

    public static final String PROPERTYNAME_errorcount = "errorcount";
    public static final String PROPERTYNAME_errormessage  = "errormessage ";
    public static final String PROPERTYNAME_employee_permission_id = "employee_permission_id";
    public static final String PROPERTYNAME_permission_id = "permission_id";
    public static final String PROPERTYNAME_percentage = "percentage";
    public static final String PROPERTYNAME_description_key = "description_key";
    public static final String PROPERTYNAME_start_date = "start_date";
    public static final String PROPERTYNAME_end_date = "end_date";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_work_place_id = "work_place_id";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_is_active = "is_active";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";

    @Id
    private int employee_permission_id;
    private int errorcount=0;
    private String permission_id;
    private int percentage;

    private String description_key;
    private LocalDate start_date= null;
    private LocalDate end_date= null;
    private int company_id=0;
    private int work_place_id;
    private int version=0;
    private boolean is_active;
    private LocalDateTime created_datetime ;
    private LocalDateTime modified_datetime ;

    private String employee_id;
}

