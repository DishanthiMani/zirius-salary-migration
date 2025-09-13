package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.CompanyFreeCarDetailsObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarBenefits;
import com.zirius.zerp.model.zerp.CompanyFreeCarDetails;
import com.zirius.zerp.model.zerp.CompanyFreeCarInsurance;
import com.zirius.zerp.model.zerp.CompanyFreeCarSetting;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

public class CompanyFreeCarDetailsMapper {

    public static CompanyFreeCarDetailsObject toEntity(CompanyFreeCarDetails dto, Integer companyId, CompanyConfigRepository repo, ObjectNode jsonNode) {

        CompanyFreeCarDetailsObject entity = new CompanyFreeCarDetailsObject();

        dto.setCOMPANY_FREE_CAR_DETAILS_ID(null);

        entity.setRegisterNo(dto.getREGISTER_NO());
        entity.setModel(dto.getMODEL());
        entity.setRegisteredDate(dto.getREGISTERED_DATE());
        entity.setBrand(dto.getBRAND());

        if (dto.getLIST_PRICE() != null) {
            entity.setListPrice(new java.math.BigDecimal(dto.getLIST_PRICE()));
        }

        entity.setCompanyFreeCarSettingsId(0);
        entity.setCompanyFreeCarBenefitsId(0);
        entity.setCompanyFreeCarInsuranceId(0);
        entity.setCompanyId(companyId);
        entity.setIsActive(dto.isIS_ACTIVE());

        entity.setVersion(dto.getVERSION());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        entity.setCreatedDatetime(dto.getCREATED_DATETIME());

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        repo.save(entity);

        if (entity.getCompanyFreeCarDetailsId() != null) {
            jsonNode.put("ziriusId", entity.getCompanyFreeCarDetailsId());
            jsonNode.put("isUpdated", "true");
        }

        return entity;
    }
}
