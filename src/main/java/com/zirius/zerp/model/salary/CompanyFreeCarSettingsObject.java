package com.zirius.zerp.model.salary;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "company_free_car_settings", schema = "salary")
@Data
public class CompanyFreeCarSettingsObject {

    @Id
    @Column(name = "COMPANY_FREE_CAR_SETTINGS_ID")
    private Integer companyFreeCarSettingsId;

    @Column(name = "IS_CAR_POOL")
    private Boolean isCarPool;

    @Column(name = "IS_DRIVING_OVER_40000")
    private Boolean isDrivingOver40000;

    @Column(name = "IS_ELECTRIC_CAR")
    private Boolean isElectricCar;

    @Column(name = "IS_COMMERCIAL_VEHICLE")
    private Boolean isCommercialVehicle;

    @Column(name = "COMPANY_ID")
    private Integer companyId;

    @Column(name = "VERSION")
    private Integer version;

    @Column(name = "CREATED_DATETIME")
    private Date createdDatetime;

    @Column(name = "MODIFIED_DATETIME")
    private Date modifiedDatetime;

    @Column(name = "INACTIVE")
    private Boolean inactive;

    @Column(name = "TO_BE_DELETED")
    private Boolean toBeDeleted;
}
