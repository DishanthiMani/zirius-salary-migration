package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.CompanyFreeCarDetailsObject;
import com.zirius.zerp.model.salary.CompanyFreeCarSettingsObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarDetails;
import com.zirius.zerp.model.zerp.CompanyFreeCarSetting;
import com.zirius.zerp.repo.SalaryRepo;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

public class CompanyFreeCarSettingsMapper {

    public static CompanyFreeCarSettingsObject toEntity(CompanyFreeCarSetting dto, CompanyFreeCarDetailsObject freeCar, Integer companyId, SalaryRepo repo, ObjectNode jsonNode) {

        CompanyFreeCarSettingsObject entity = new CompanyFreeCarSettingsObject();

        entity.setCompanyFreeCarSettingsId(freeCar.getCompanyFreeCarDetailsId());
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

        repo.save(entity);
        if (entity.getCompanyFreeCarSettingsId() != null) {
            jsonNode.put("ziriusId", entity.getCompanyFreeCarSettingsId());
            jsonNode.put("isUpdated", "true");

            freeCar.setCompanyFreeCarSettingsId(entity.getCompanyFreeCarSettingsId());
            repo.update(freeCar);
        }

        return entity;
    }
}
