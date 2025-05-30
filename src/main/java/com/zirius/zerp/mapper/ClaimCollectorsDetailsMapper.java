package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.ClaimCollectorsDetailsObject;
import com.zirius.zerp.model.zerp.ClaimCollectorDetails;
import com.zirius.zerp.model.zerp.ClaimCollectorValues;

import java.math.BigDecimal;

public class ClaimCollectorsDetailsMapper {

    public static ClaimCollectorsDetailsObject toEntity(ClaimCollectorDetails dto, Integer companyId, ClaimCollectorValues claimValues) {
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
        entity.setTotalAmount(BigDecimal.valueOf(claimValues.getTOTAL_AMOUNT()));
        entity.setPercentage(BigDecimal.valueOf(claimValues.getPERCENTAGE()));
        entity.setIsStartingBalance(claimValues.isIS_STARTING_BALANCE());
        entity.setMinAmount(BigDecimal.valueOf(claimValues.getMIN_AMOUNT()));
        entity.setMaxAmount(BigDecimal.valueOf(claimValues.getMAX_AMOUNT()));

        entity.setIsActive(dto.getIS_ACTIVE());
        entity.setVersion(dto.getVERSION() != null ? dto.getVERSION().intValue() : 1);

        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }
}
