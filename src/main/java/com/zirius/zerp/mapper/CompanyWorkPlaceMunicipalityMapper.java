package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.WorkPlaceMunicipalityObject;
import com.zirius.zerp.model.salary.WorkPlaceObject;
import com.zirius.zerp.model.zerp.CompanyWorkPlaceMunicipality;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

public class CompanyWorkPlaceMunicipalityMapper {

    public static WorkPlaceMunicipalityObject toEntity(CompanyWorkPlaceMunicipality dto, WorkPlaceObject workPlaceObject, Integer companyId,
                                                       CompanyConfigRepository repo, ObjectNode jsonNode) {
        WorkPlaceMunicipalityObject entity = new WorkPlaceMunicipalityObject();


        entity.setWorkPlaceMunicipalityId(null);

        entity.setCompanyId(companyId);

        entity.setWorkPlaceId(workPlaceObject.getWorkPlaceId());
        entity.setYear(dto.getYEAR());


        entity.setMunicipalityId(dto.getMUNICIPALITY_ID() != null
                ? dto.getMUNICIPALITY_ID().intValue() : null);

        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());
        entity.setVersion(dto.getVERSION());

        // Default values for optional fields
        entity.setInactive(false);
        entity.setToBeDeleted(false);

        repo.save(entity);

        if (entity.getWorkPlaceMunicipalityId() != null) {
            jsonNode.put("ziriusId", entity.getWorkPlaceMunicipalityId());
            jsonNode.put("isUpdated", "true");
        }

        return entity;
    }
}
