package com.zirius.zerp.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.WorkPlaceMunicipalityObject;
import com.zirius.zerp.model.salary.WorkPlaceObject;
import com.zirius.zerp.model.zerp.CompanyWorkPlace;
import com.zirius.zerp.model.zerp.CompanyWorkPlaceMunicipality;
import com.zirius.zerp.repo.SalaryRepo;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class CompanyWorkPlaceMapper {

    public static WorkPlaceObject toEntity(CompanyWorkPlace dto, Integer companyId,
                                           SalaryRepo repo, ObjectNode jsonNode) {
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

        repo.save(entity);

        if (entity.getWorkPlaceId() != null) {
            jsonNode.put("ziriusId", entity.getWorkPlaceId());
            jsonNode.put("isUpdated", "true");
        }


        return entity;
    }
}
