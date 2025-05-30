package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.AltinnUserObject;
import com.zirius.zerp.model.zerp.AltinnUser;

import java.util.Optional;

public class AltinnUserMapper {

    public static AltinnUserObject toEntity(AltinnUser dto, Integer companyId) {
        AltinnUserObject entity = new AltinnUserObject();

        entity.setAltinnUserId(Optional.ofNullable(dto.getALTINN_USER_ID()).map(Long::intValue).orElse(null));
        entity.setCompanyId(companyId);
        entity.setUserId(Optional.ofNullable(dto.getUSER_ID()).map(Long::intValue).orElse(null));
        entity.setSsn(dto.getSsn());
        entity.setSystemName(dto.getSYSTEM_NAME());
        entity.setSystemPassword(dto.getSYSTEM_PASSWORD());
        entity.setUserName(dto.getUSER_NAME());
        entity.setUserPassword(dto.getUSER_PASSWORD());
        entity.setPhoneNumber(dto.getPHONE_NUMBER());
        entity.setDescription(dto.getDESCRIPTION());
        entity.setIsDefault(Boolean.TRUE.equals(dto.getIS_DEFAULT()));
        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        entity.setVersion(dto.getVERSION());

        // Set default or empty values if not available in DTO
        entity.setInactive(false);
        entity.setToBeDeleted(false);
        entity.setEmployeeId(""); // Provide a value based on your logic

        return entity;
    }
}
