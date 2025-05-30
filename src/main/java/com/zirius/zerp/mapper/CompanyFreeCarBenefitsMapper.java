package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.CompanyFreeCarBenefitsObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarBenefits;

import java.math.BigDecimal;

public class CompanyFreeCarBenefitsMapper {

    public static CompanyFreeCarBenefitsObject toEntity(CompanyFreeCarBenefits dto, Integer companyId) {
        CompanyFreeCarBenefitsObject entity = new CompanyFreeCarBenefitsObject();

        if (dto.getCompanyFreeCarBenefitId() != null) {
            entity.setCompanyFreeCarBenefitsId(dto.getCompanyFreeCarBenefitId().intValue());
        }

        entity.setSalaryReportingCodeId(dto.getSalaryReportingCodeId());

        if (dto.getANNUAL_BENEFIT() != null) {
            entity.setAnnualBenefit(BigDecimal.valueOf(dto.getANNUAL_BENEFIT()));
        }

        if (dto.getAMOUNT_PER_SETTLEMENT() != null) {
            entity.setAmountPerSettlement(BigDecimal.valueOf(dto.getAMOUNT_PER_SETTLEMENT()));
        }

        if (dto.getPRICE() != null) {
            entity.setPrice(BigDecimal.valueOf(dto.getPRICE()));
        }

        entity.setCompanyId(companyId);

        if (dto.getVersion() != 0) {
            entity.setVersion(dto.getVersion());
        }

        if (dto.getCREATED_DATETIME() != null) {
            entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        }

        if (dto.getModifiedDateTime() != null) {
            entity.setModifiedDatetime(dto.getModifiedDateTime());
        }

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }
}
