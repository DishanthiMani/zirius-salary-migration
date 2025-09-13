package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "company_pension_otp", schema = "salary")
@Data
public class CompanyPensionOtpObject {

    public static final String PROPERTYNAME_otpId = "OTP_ID";
    public static final String PROPERTYNAME_pensionOtpId = "PENSION_OTP_ID";
    public static final String PROPERTYNAME_companyId = "COMPANY_ID";
    public static final String PROPERTYNAME_orgNo = "ORG_NO";
    public static final String PROPERTYNAME_name = "NAME";
    public static final String PROPERTYNAME_isActive = "IS_ACTIVE";
    public static final String PROPERTYNAME_isCustom = "IS_CUSTOM";
    public static final String PROPERTYNAME_createdDatetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_modifiedDatetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_toBeDeleted = "TO_BE_DELETED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OTP_ID")
    private Integer otpId;

    @Column(name = "PENSION_OTP_ID")
    private Integer pensionOtpId;

    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "ORG_NO")
    private String orgNo;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "IS_CUSTOM")
    private Boolean isCustom;

    @Column(name = "CREATED_DATETIME")
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    private Date modifiedDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;

}
