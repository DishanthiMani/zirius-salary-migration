package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.CompanyFreeCarSettingsObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarSetting;

public class CompanyFreeCarSettingsMapper {

    public static CompanyFreeCarSettingsObject toEntity(CompanyFreeCarSetting dto, Integer companyId) {
        CompanyFreeCarSettingsObject entity = new CompanyFreeCarSettingsObject();

        entity.setCompanyFreeCarSettingsId(null);
        entity.setIsCarPool(dto.isIS_CAR_POOL());
        entity.setIsDrivingOver40000(dto.isIS_DRIVING_OVER_40000());
        entity.setIsElectricCar(dto.isIS_ELECTRIC_CAR());
        entity.setIsCommercialVehicle(dto.isIS_COMMERCIAL_VEHICLE());
        entity.setCompanyId(companyId);
        entity.setVersion(dto.getVERSION());
        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());

        // Set default values for optional fields
        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }
}
