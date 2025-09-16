package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.CompanyFreeCarBenefitsObject;
import com.zirius.zerp.model.salary.CompanyFreeCarDetailsObject;
import com.zirius.zerp.model.zerp.CompanyFreeCarBenefits;
import com.zirius.zerp.repo.SalaryRepo;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

import java.math.BigDecimal;

public class CompanyFreeCarBenefitsMapper {

    public static CompanyFreeCarBenefitsObject toEntity(CompanyFreeCarBenefits dto, CompanyFreeCarDetailsObject freeCar, Integer companyId, SalaryRepo repo, ObjectNode jsonNode) {
        CompanyFreeCarBenefitsObject entity = new CompanyFreeCarBenefitsObject();

        entity.setCompanyFreeCarBenefitsId(freeCar.getCompanyFreeCarDetailsId());


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

        entity.setVersion(dto.getVersion());


        if (dto.getCREATED_DATETIME() != null) {
            entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        }

        if (dto.getModifiedDateTime() != null) {
            entity.setModifiedDatetime(dto.getModifiedDateTime());
        }

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        repo.save(entity);

        if (entity.getCompanyFreeCarBenefitsId() != null) {
            jsonNode.put("ziriusId", entity.getCompanyFreeCarBenefitsId());
            jsonNode.put("isUpdated", "true");

            freeCar.setCompanyFreeCarBenefitsId(entity.getCompanyFreeCarBenefitsId());
            repo.update(freeCar);
        }

        return entity;
    }
}
