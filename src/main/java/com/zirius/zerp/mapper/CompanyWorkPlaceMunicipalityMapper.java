package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.WorkPlaceMunicipalityObject;
import com.zirius.zerp.model.zerp.CompanyWorkPlaceMunicipality;

public class CompanyWorkPlaceMunicipalityMapper {

    public static WorkPlaceMunicipalityObject toEntity(CompanyWorkPlaceMunicipality dto, Integer companyId) {
        WorkPlaceMunicipalityObject entity = new WorkPlaceMunicipalityObject();


        entity.setWorkPlaceMunicipalityId(null);

        entity.setCompanyId(companyId);

        entity.setWorkPlaceId(dto.getWORK_PLACE_ID());
        entity.setYear(dto.getYEAR());


        entity.setMunicipalityId(dto.getMUNICIPALITY_ID() != null
                ? dto.getMUNICIPALITY_ID().intValue() : null);

        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        entity.setVersion(dto.getVERSION());

        // Default values for optional fields
        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }
}
