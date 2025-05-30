package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "altinn_user")
@Data
public class AltinnUserObject {

    public static final String PROPERTYNAME_altinnUserId = "ALTINN_USER_ID";
    public static final String PROPERTYNAME_companyId = "COMPANY_ID";
    public static final String PROPERTYNAME_userId = "USER_ID";
    public static final String PROPERTYNAME_ssn = "SSN";
    public static final String PROPERTYNAME_systemName = "SYSTEM_NAME";
    public static final String PROPERTYNAME_systemPassword = "SYSTEM_PASSWORD";
    public static final String PROPERTYNAME_userName = "USER_NAME";
    public static final String PROPERTYNAME_userPassword = "USER_PASSWORD";
    public static final String PROPERTYNAME_phoneNumber = "PHONE_NUMBER";
    public static final String PROPERTYNAME_description = "DESCRIPTION";
    public static final String PROPERTYNAME_isDefault = "IS_DEFAULT";
    public static final String PROPERTYNAME_createdDatetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modifiedDatetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_toBeDeleted = "TO_BE_DELETED";
    public static final String PROPERTYNAME_employeeId = "EMPLOYEE_ID";

    @Id
    @Column(name = "ALTINN_USER_ID")
    private Integer altinnUserId;

    @Id
    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "USER_ID", nullable = false)
    private Integer userId;

    @Column(name = "SSN")
    private String ssn;

    @Column(name = "SYSTEM_NAME", nullable = false)
    private String systemName;

    @Column(name = "SYSTEM_PASSWORD", nullable = false)
    private String systemPassword;

    @Column(name = "USER_NAME", nullable = false)
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
