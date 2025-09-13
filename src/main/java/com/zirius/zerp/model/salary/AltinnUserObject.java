package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "altinn_user", schema = "salary")
@Data
public class AltinnUserObject {

    public static final String PROPERTYNAME_altinn_user_id = "altinn_user_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_user_id = "user_id";
    public static final String PROPERTYNAME_ssn = "ssn";
    public static final String PROPERTYNAME_system_name = "system_name";
    public static final String PROPERTYNAME_system_password = "system_password";
    public static final String PROPERTYNAME_user_name = "user_name";
    public static final String PROPERTYNAME_user_password = "user_password";
    public static final String PROPERTYNAME_phone_number = "phone_number";
    public static final String PROPERTYNAME_description = "description";
    public static final String PROPERTYNAME_is_default = "is_default";
    public static final String PROPERTYNAME_created_datetime = "created_datetime";
    public static final String PROPERTYNAME_modified_datetime = "modified_datetime";
    public static final String PROPERTYNAME_version = "version";
    public static final String PROPERTYNAME_inactive = "inactive";
    public static final String PROPERTYNAME_to_be_deleted = "to_be_deleted";
    public static final String PROPERTYNAME_employee_id = "employee_id";

    @Id
    @Column(name = "altinn_user_id")
    private Integer altinnUserId;

    @Id
    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @Column(name = "ssn")
    private String ssn;

    @Column(name = "system_name", nullable = false)
    private String systemName;

    @Column(name = "system_password", nullable = false)
    private String systemPassword;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "USER_PASSWORD", nullable = false)
    private String userPassword;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IS_DEFAULT")
    private Boolean isDefault;

    @Column(name = "CREATED_DATETIME", nullable = false)
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME", nullable = false)
    private Date modifiedDatetime;

    @Column(name = "VERSION", nullable = false)
    private Integer version;

    @Column(name = "INACTIVE")
    private Boolean inactive = false;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted = false;

    @Column(name = "EMPLOYEE_ID", nullable = false)
    private String employeeId;
}
