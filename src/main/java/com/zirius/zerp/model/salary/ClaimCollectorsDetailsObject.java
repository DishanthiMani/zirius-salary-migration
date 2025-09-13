package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "claim_collectors_details", schema = "salary")
@Data
public class ClaimCollectorsDetailsObject {

    public static final String PROPERTYNAME_claimCollectorsId = "CLAIM_COLLECTORS_ID";
    public static final String PROPERTYNAME_name = "NAME";
    public static final String PROPERTYNAME_address = "ADDRESS";
    public static final String PROPERTYNAME_address1 = "ADDRESS_1";
    public static final String PROPERTYNAME_address2 = "ADDRESS_2";
    public static final String PROPERTYNAME_postalCode = "POSTAL_CODE";
    public static final String PROPERTYNAME_bankAccountNo = "BANK_ACCOUNT_NO";
    public static final String PROPERTYNAME_bankAccountId = "BANK_ACCOUNT_ID";
    public static final String PROPERTYNAME_enableBankPayment = "ENABLE_BANK_PAYMENT";
    public static final String PROPERTYNAME_kidNo = "KID_NO";
    public static final String PROPERTYNAME_totalAmount = "TOTAL_AMOUNT";
    public static final String PROPERTYNAME_percentage = "PERCENTAGE";
    public static final String PROPERTYNAME_isStartingBalance = "IS_STARTING_BALANCE";
    public static final String PROPERTYNAME_minAmount = "MIN_AMOUNT";
    public static final String PROPERTYNAME_maxAmount = "MAX_AMOUNT";
    public static final String PROPERTYNAME_companyId = "COMPANY_ID";
    public static final String PROPERTYNAME_isActive = "IS_ACTIVE";
    public static final String PROPERTYNAME_version = "VERSION";
    public static final String PROPERTYNAME_modifiedDatetime = "MODIFIED_DATETIME";
    public static final String PROPERTYNAME_createdDatetime = "CREATED_DATETIME";
    public static final String PROPERTYNAME_inactive = "INACTIVE";
    public static final String PROPERTYNAME_toBeDeleted = "TO_BE_DELETED";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CLAIM_COLLECTORS_ID")
    private Integer claimCollectorsId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ADDRESS_1")
    private String address1;

    @Column(name = "ADDRESS_2")
    private String address2;

    @Column(name = "POSTAL_CODE")
    private String postalCode;

    @Column(name = "BANK_ACCOUNT_NO", nullable = false)
    private String bankAccountNo;

    @Column(name = "BANK_ACCOUNT_ID")
    private Integer bankAccountId;

    @Column(name = "ENABLE_BANK_PAYMENT")
    private Boolean enableBankPayment;

    @Column(name = "KID_NO")
    private String kidNo;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @Column(name = "PERCENTAGE")
    private BigDecimal percentage;

    @Column(name = "IS_STARTING_BALANCE")
    private Boolean isStartingBalance;

    @Column(name = "MIN_AMOUNT")
    private BigDecimal minAmount;

    @Column(name = "MAX_AMOUNT")
    private BigDecimal maxAmount;


    @Column(name = "COMPANY_ID", nullable = false)
    private Integer companyId;

    @Column(name = "IS_ACTIVE")
    private Boolean isActive;

    @Column(name = "VERSION", nullable = false)
    private Integer version;

    @Column(name = "MODIFIED_DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDatetime;

    @Column(name = "CREATED_DATETIME", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive = false;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted = false;
}
