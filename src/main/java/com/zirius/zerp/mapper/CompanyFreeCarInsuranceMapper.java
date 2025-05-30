package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.CompanyFreeCarInsuranceObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarInsurance;

import java.math.BigDecimal;

public class CompanyFreeCarInsuranceMapper {

    public static CompanyFreeCarInsuranceObject toEntity(CompanyFreeCarInsurance dto, Integer companyId) {
        CompanyFreeCarInsuranceObject entity = new CompanyFreeCarInsuranceObject();


        entity.setCompanyFreeCarInsuranceId(null);

        entity.setInsuranceDate(dto.getINSURANCE_DATE());

        if (dto.getDISTANCE_TRAVELLED_TILL() != null) {
            entity.setDistanceTravelledTill(dto.getDISTANCE_TRAVELLED_TILL().intValue());
        }

        if (dto.getDISTANCE_TRAVELLED_PER_YEAR() != null) {
            entity.setDistanceTravelledPerYear(dto.getDISTANCE_TRAVELLED_PER_YEAR().intValue());
        }

        if (dto.getDEDUCTABLE() != null) {
            entity.setDeductable(BigDecimal.valueOf(dto.getDEDUCTABLE()));
        }

        entity.setCorportation(dto.getCORPORTATION());
        entity.setCompanyId(companyId);
        entity.setVersion(dto.getVERSION());
        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());

        // Default values
        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }
}
