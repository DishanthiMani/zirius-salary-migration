package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.CompanyFreeCarDetailsObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarDetails;

public class CompanyFreeCarDetailsMapper {

    public static CompanyFreeCarDetailsObject toEntity(CompanyFreeCarDetails dto, Integer companyId) {
        CompanyFreeCarDetailsObject entity = new CompanyFreeCarDetailsObject();

        dto.setCOMPANY_FREE_CAR_DETAILS_ID(null);

        entity.setRegisterNo(dto.getREGISTER_NO());
        entity.setModel(dto.getMODEL());
        entity.setRegisteredDate(dto.getREGISTERED_DATE());
        entity.setBrand(dto.getBRAND());

        if (dto.getLIST_PRICE() != null) {
            entity.setListPrice(new java.math.BigDecimal(dto.getLIST_PRICE()));
        }

        entity.setCompanyFreeCarSettingsId(dto.getCOMPANY_FREE_CAR_SETTINGS_ID());
        entity.setCompanyFreeCarBenefitsId(dto.getCOMPANY_FREE_CAR_BENEFITS_ID());
        entity.setCompanyFreeCarInsuranceId(dto.getCOMPANY_FREE_CAR_INSURANCE_ID());
        entity.setCompanyId(companyId);
        entity.setIsActive(dto.isIS_ACTIVE());

        entity.setVersion(dto.getVERSION());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        entity.setCreatedDatetime(dto.getCREATED_DATETIME());

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }
}
