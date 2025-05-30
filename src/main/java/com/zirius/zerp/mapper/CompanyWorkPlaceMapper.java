package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.WorkPlaceObject;
import com.zirius.zerp.model.zerp.CompanyWorkPlace;

import java.util.Optional;

public class CompanyWorkPlaceMapper {

    public static WorkPlaceObject toEntity(CompanyWorkPlace dto, Integer companyId) {
        WorkPlaceObject entity = new WorkPlaceObject();

        entity.setWorkPlaceId(null);
        entity.setCompanyId(companyId);

        entity.setWorkPlaceCode(dto.getWORK_PLACE_CODE());
        entity.setWorkPlaceName(dto.getWORK_PLACE_NAME());
        entity.setBusinessNumber(dto.getBUSINESS_NUMBER());
        entity.setMunicipalityId(dto.getMUNICIPALITY_ID());

        entity.setIsDeleted(Boolean.TRUE.equals(dto.getIS_DELETED()));
        entity.setIsFloatingWorkPlace(Boolean.TRUE.equals(dto.isIS_FLOATING_WORK_PLACE()));

        if (dto.getCREATED_DATETIME() != null) {
            entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        }

        if (dto.getMODIFIED_DATETIME() != null) {
            entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        }

        entity.setVersion(dto.getVERSION());

        // Default or placeholders for optional fields in WorkPlaceObject
        entity.setInactive(false); // or set based on your logic
        entity.setToBeDeleted(false); // or set based on your logic

        return entity;
    }
}
