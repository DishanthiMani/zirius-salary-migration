package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.CompanyPensionOtpObject;
import com.zirius.zerp.model.zerp.CompanyPensionOTP;

public class CompanyPensionOtpMapper {

    public static CompanyPensionOtpObject toEntity(CompanyPensionOTP dto, Integer companyId) {
        CompanyPensionOtpObject entity = new CompanyPensionOtpObject();

        if (dto.getOTP_ID() != null) {
            entity.setOtpId(dto.getOTP_ID().intValue());
        }

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

        return entity;
    }
}
