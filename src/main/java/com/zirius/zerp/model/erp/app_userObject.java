package com.zirius.zerp.model.erp;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "app_user", schema = "erp")
public class app_userObject {

    public static final String PROPERTYNAME_user_id = "user_id";
    public static final String PROPERTYNAME_sso_id = "sso_id";
    public static final String PROPERTYNAME_zerp_user_id = "zerp_user_id";
    public static final String PROPERTYNAME_email = "email";
    public static final String PROPERTYNAME_phone = "phone";
    public static final String PROPERTYNAME_name = "name";
    public static final String PROPERTYNAME_address1 = "address1";
    public static final String PROPERTYNAME_address2 = "address2";
    public static final String PROPERTYNAME_address3 = "address3";
    public static final String PROPERTYNAME_postalcode = "postalcode";
    public static final String PROPERTYNAME_city = "city";
    public static final String PROPERTYNAME_state = "state";
    public static final String PROPERTYNAME_countrycode = "countrycode";
    public static final String PROPERTYNAME_active = "active";
    public static final String PROPERTYNAME_super_user = "super_user";
    public static final String PROPERTYNAME_api_user = "api_user";
    public static final String PROPERTYNAME_associated_user_id = "associated_user_id";
    public static final String PROPERTYNAME_description = "description";
    public static final String PROPERTYNAME_is_self_signed_up = "is_self_signed_up";
    public static final String PROPERTYNAME_is_new_user = "is_new_user";
    public static final String PROPERTYNAME_eula = "eula";
    public static final String PROPERTYNAME_created_date_time = "created_date_time";
    public static final String PROPERTYNAME_modified_date_time = "modified_date_time";
    public static final String PROPERTYNAME_expiry_date_time = "expiry_date_time";
    public static final String PROPERTYNAME_last_login_time = "last_login_time";
    public static final String PROPERTYNAME_inactive = "inactive";
    public static final String PROPERTYNAME_to_be_deleted = "to_be_deleted";

    @Id
    private String user_id;
    private String sso_id;
    private int zerp_user_id;
    private String email = "";
    private String phone;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String postalcode;
    private String city;
    private String state;
    private String countrycode;
    private boolean active;
    private boolean super_user;
    private boolean api_user;
    private String associated_user_id;
    private String description;
    private boolean is_self_signed_up;
    private boolean is_new_user;
    private boolean eula;
    private LocalDateTime created_date_time;
    private LocalDateTime modified_date_time;
    private LocalDate expiry_date_time = null;
    private LocalDateTime last_login_time;
    private boolean inactive;
    private boolean to_be_deleted;

}
