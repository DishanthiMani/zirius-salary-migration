package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.CompanySalaryDetailsObject;
import com.zirius.zerp.model.zerp.CompanySalaryDetails;
import com.zirius.zerp.repo.SalaryRepo;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

public class CompanySalaryDetailsMapper {

    public static CompanySalaryDetailsObject toEntity(CompanySalaryDetails dto, Integer companyId, SalaryRepo repo, ObjectNode jsonNode) {
        CompanySalaryDetailsObject entity = new CompanySalaryDetailsObject();

        if (dto.getCOMPANY_ID() != null) {
            entity.setCompanyId(companyId);
        }

        entity.setMunicipalityId(dto.getMUNICIPALITY_ID());
        entity.setChangedSalaryDetails(dto.getCHANGED_SALARY_DETAILS());
        entity.setNaceCode(dto.getNACE_CODE());
        entity.setIsPensionScheme(Boolean.TRUE.equals(dto.getIS_PENSION_SCHEME()));
        entity.setPensionProvider(dto.getPENSION_PROVIDER());
        entity.setCompanyOrganizationTypeId(dto.getCOMPANY_ORGANIZATION_TYPE_ID());
        entity.setIsFinancialDifficultyEnabled(Boolean.TRUE.equals(dto.getIS_FINANCIAL_DIFFICULTY_ENABLED()));

        if (dto.getVERSION() != null) {
            entity.setVersion(dto.getVERSION().intValue());
        }

        if (dto.getCREATED_DATETIME() != null) {
            entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        }

        if (dto.getMODIFIED_DATETIME() != null) {
            entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        }


        entity.setActiveFinancialDifficultyStartMonth(null);
        entity.setActiveFinancialDifficultyEndMonth(null);

        repo.save(entity);
        if (repo.getCompanySalaryDetails(companyId).getCompanyId() != null) {
            jsonNode.put("ziriusId", entity.getCompanyId());
            jsonNode.put("isUpdated", "true");
        }

        return entity;
    }
}
