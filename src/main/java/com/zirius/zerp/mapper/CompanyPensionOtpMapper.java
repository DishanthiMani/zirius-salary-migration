package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.CompanyPensionOtpObject;
import com.zirius.zerp.model.zerp.CompanyPensionOTP;
import com.zirius.zerp.repo.SalaryRepo;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

public class CompanyPensionOtpMapper {

    public static CompanyPensionOtpObject toEntity(CompanyPensionOTP dto, Integer companyId, SalaryRepo repo, ObjectNode jsonNode) {
        CompanyPensionOtpObject entity = new CompanyPensionOtpObject();


        entity.setOtpId(null);
        entity.setCompanyId(companyId);
        entity.setOrgNo(dto.getORG_NO());
        entity.setName(dto.getNAME());
        entity.setPensionOtpId(dto.getPENSION_OTP_ID());
        entity.setIsActive(Boolean.TRUE.equals(dto.isIS_ACTIVE()));
        entity.setIsCustom(Boolean.TRUE.equals(dto.isIS_CUSTOM()));
        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        repo.save(entity);
        if (entity.getOtpId() != null) {

            jsonNode.put("ziriusId", entity.getOtpId());
            jsonNode.put("isUpdated", "true");
        }

        return entity;
    }
}
