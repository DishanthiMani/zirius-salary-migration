package com.zirius.zerp.model.salary;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "employee_work_place", schema = "salary")
public class EmployeeWorkPlace {

    public static final String PROPERTYNAME_employee_work_place_id = "employee_work_place_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_work_place_id = "work_place_id";
    public static final String PROPERTYNAME_appointments_id = "appointments_id";
    public static final String PROPERTYNAME_work_percentage = "work_percentage";
    public static final String PROPERTYNAME_from_date = "from_date";
    public static final String PROPERTYNAME_to_date = "to_date";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";
    public static final String PROPERTYNAME_inactive = "inactive";
    public static final String PROPERTYNAME_to_be_deleted = "to_be_deleted";


    @Id
    private int employee_work_place_id;
    private int company_id=0;
    private int work_place_id;
    private int appointments_id;
    private int work_percentage;
    private LocalDate from_date= null;
    private LocalDate to_date= null;
    private int version=0;
    private LocalDateTime created_datetime ;
    private LocalDateTime modified_datetime ;
    private String employee_id;
    private boolean inactive;
    private boolean to_be_deleted;

}
