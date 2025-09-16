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
@Table(name = "employee_appointments", schema = "salary")
public class EmployeeAppointments {

    public static final String PROPERTYNAME_appointments_id = "appointments_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_status_id = "status_id";
    public static final String PROPERTYNAME_starting_date = "starting_date";
    public static final String PROPERTYNAME_ending_date = "ending_date";
    public static final String PROPERTYNAME_employee_end_reason_id = "employee_end_reason_id";
    public static final String PROPERTYNAME_confirmation_date = "confirmation_date";
    public static final String PROPERTYNAME_hours_per_day = "hours_per_day";
    public static final String PROPERTYNAME_nearest_boss_id = "nearest_boss_id";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_employee_id = "employee_id";
    public static final String PROPERTYNAME_work_relationship_type = "work_relationship_type";
    public static final String PROPERTYNAME_employment_type_id = "employment_type_id";
    public static final String PROPERTYNAME_ship_register = "ship_register";
    public static final String PROPERTYNAME_vessel_type = "vessel_type";
    public static final String PROPERTYNAME_shipping_area = "shipping_area";
    public static final String PROPERTYNAME_occupation_code = "occupation_code";
    public static final String PROPERTYNAME_position_designation = "position_designation";
    public static final String PROPERTYNAME_renumeration_type = "renumeration_type";
    public static final String PROPERTYNAME_work_time_scheme = "work_time_scheme";
    public static final String PROPERTYNAME_number_of_hours_per_week = "number_of_hours_per_week";
    public static final String PROPERTYNAME_worker_id = "worker_id";
    public static final String PROPERTYNAME_last_salary_change = "last_salary_change";
    public static final String PROPERTYNAME_last_changed_position_percent = "last_changed_position_percent";
    public static final String PROPERTYNAME_work_percentage = "work_percentage";
    public static final String PROPERTYNAME_inactive = "inactive";
    public static final String PROPERTYNAME_to_be_deleted = "to_be_deleted";

    @Id
    private int appointments_id;
    private int company_id=0;
    private int status_id;
    private LocalDate starting_date= null;
    private LocalDate ending_date= null;
    private int employee_end_reason_id;
    private LocalDate confirmation_date= null;
    private BigDecimal hours_per_day = new BigDecimal("0");
    private String nearest_boss_id;
    private int version=0;
    private LocalDateTime created_datetime ;
    private LocalDateTime modified_datetime ;
    private String employee_id="";
    private int work_relationship_type;
    private int employment_type_id;
    private int ship_register;
    private int vessel_type;
    private int shipping_area;
    private int occupation_code;
    private String position_designation;
    private int renumeration_type;
    private int work_time_scheme;
    private BigDecimal number_of_hours_per_week = new BigDecimal("0");
    private String worker_id;
    private LocalDate last_salary_change= null;
    private LocalDate last_changed_position_percent= null;
    private int work_percentage;
    private boolean inactive;
    private boolean to_be_deleted;
}

