package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.model.salary.ClaimCollectorsDetailsObject;
import com.zirius.zerp.model.zerp.ClaimCollectorDetails;
import com.zirius.zerp.model.zerp.ClaimCollectorValues;
import com.zirius.zerp.repo.SalaryRepo;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;

import java.math.BigDecimal;

public class ClaimCollectorsDetailsMapper {

    public static ClaimCollectorsDetailsObject toEntity(ClaimCollectorDetails dto, Integer companyId, ClaimCollectorValues claimValues,
                                                        SalaryRepo repo, ObjectNode jsonNode) {
        ClaimCollectorsDetailsObject entity = new ClaimCollectorsDetailsObject();

        entity.setClaimCollectorsId(null);
        entity.setCompanyId(companyId);

        entity.setName(dto.getNAME());
        entity.setAddress(dto.getADDRESS());
        entity.setAddress1(dto.getADDRESS_1());
        entity.setAddress2(dto.getADDRESS_2());
        entity.setPostalCode(dto.getPOSTAL_CODE());
        entity.setBankAccountNo(dto.getBANK_ACCOUNT_NO());

        entity.setBankAccountId(dto.getBANK_ACCOUNT_ID() != null ? dto.getBANK_ACCOUNT_ID().intValue() : null);
        entity.setEnableBankPayment(dto.getENABLE_BANK_PAYMENT());


        entity.setKidNo(claimValues.getKID_NO());
        entity.setTotalAmount(claimValues.getTOTAL_AMOUNT() != null ? BigDecimal.valueOf(claimValues.getTOTAL_AMOUNT()) : BigDecimal.ZERO);
        entity.setPercentage(claimValues.getPERCENTAGE() != null ? BigDecimal.valueOf(claimValues.getPERCENTAGE()) : BigDecimal.ZERO);
        entity.setIsStartingBalance(claimValues.isIS_STARTING_BALANCE());
        entity.setMinAmount(claimValues.getMIN_AMOUNT() != null ? BigDecimal.valueOf(claimValues.getMIN_AMOUNT()) : BigDecimal.ZERO);
        entity.setMaxAmount(claimValues.getMAX_AMOUNT() != null ? BigDecimal.valueOf(claimValues.getMAX_AMOUNT()) : BigDecimal.ZERO);

        entity.setIsActive(dto.getIS_ACTIVE());
        entity.setVersion(dto.getVERSION() != null ? dto.getVERSION().intValue() : 1);

        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        repo.save(entity);

        if (entity.getClaimCollectorsId() != null) {

            jsonNode.put("ziriusId", entity.getClaimCollectorsId());
            jsonNode.put("isUpdated", "true");

        }

        return entity;
    }
}
