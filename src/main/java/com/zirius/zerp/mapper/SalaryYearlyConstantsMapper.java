package com.zirius.zerp.mapper;

import com.zirius.zerp.model.zerp.SalaryYearlyConstant;
import com.zirius.zerp.model.salary.SalaryYearlyConstantsConfigObject;

import java.math.BigDecimal;

public class SalaryYearlyConstantsMapper {

    public static SalaryYearlyConstantsConfigObject toEntity(SalaryYearlyConstant dto, Integer companyId) {
        SalaryYearlyConstantsConfigObject entity = new SalaryYearlyConstantsConfigObject();

        entity.setYearlyConstantsId(dto.getYEARLY_CONSTANTS_ID());
        entity.setMaxEcomRefundAmount(toBigDecimal(dto.getMAX_ECOM_REFUND_AMOUNT()));
        entity.setCarAllowanceWithTax(toBigDecimal(dto.getCAR_ALLOWANCE_WITH_TAX()));
        entity.setCarAllowanceWithoutTax(toBigDecimal(dto.getCAR_ALLOWANCE_WITHOUT_TAX()));
        entity.setCarAllowanceOverLimit(toBigDecimal(dto.getCAR_ALLOWANCE_OVER_LIMIT()));
        entity.setElectricCarAllowanceWithTax(toBigDecimal(dto.getELECTRIC_CAR_ALLOWANCE_WITH_TAX()));
        entity.setElectricCarAllowanceWithoutTax(toBigDecimal(dto.getELECTRIC_CAR_ALLOWANCE_WITHOUT_TAX()));
        entity.setElectricCarAllowanceOverLimit(toBigDecimal(dto.getELECTRIC_CAR_ALLOWANCE_OVER_LIMIT()));
        entity.setKilometerTrailer(toBigDecimal(dto.getKILOMETER_TRAILER()));
        entity.setPassengerAddition(toBigDecimal(dto.getPASSENGER_ADDITION()));
        entity.setForestAndConstructionWay(toBigDecimal(dto.getFOREST_AND_CONSTRUCTION_WAY()));
        entity.setToolAllowanceForConstructionWorkersWithoutTax(toBigDecimal(dto.getTOOL_ALLOWANCE_FOR_CONSTRUCTION_WORKERS_WITHOUT_TAX()));
        entity.setToolAllowanceForForestWorkers(toBigDecimal(dto.getTOOL_ALLOWANCE_FOR_FOREST_WORKERS()));
        entity.setFreeCarBaseValue(toBigDecimal(dto.getFREE_CAR_BASE_VALUE()));
        entity.setHolidayPayOver60Yrs(toBigDecimal(dto.getHOLIDAY_PAY_OVER_60_YRS()));
        entity.setOneGYearlyConstant(toBigDecimal(dto.getONE_G_YEARLY_CONSTANT()));
        entity.setYear(Integer.parseInt(dto.getYEAR().toString()));

        entity.setCompanyId(companyId != null ? companyId : dto.getCOMPANY_ID());

        entity.setSalaryCodeConstant(toBigDecimal(dto.getSALARY_CODE_CONSTANT()));
        entity.setPaulArbAvgOfBonusAmountConstant(toBigDecimal(dto.getPAUL_ARB_AVG_OF_BONUS_AMOUNT_CONSTANT()));
        entity.setHolidayPayAmountConstant(toBigDecimal(dto.getHOLIDAY_PAY_AMOUNT_CONSTANT()));
        entity.setMaxFreeCardAmount(toBigDecimal(dto.getMAX_FREE_CARD_AMOUNT()));
        entity.setTransportMaxFreeCardAmount(toBigDecimal(dto.getTRANSPORT_MAX_FREE_CARD_AMOUNT()));
        entity.setCompanyTaxPercent(toBigDecimal(dto.getCOMPANY_TAX_PERCENT()));
        entity.setAdditionalCompanyTaxLimit(dto.getADDITIONAL_COMPANY_TAX_LIMIT());
        entity.setAdditionalCompanyTaxPercent(toBigDecimal(dto.getADDITIONAL_COMPANY_TAX_PERCENT()));

        entity.setVersion(dto.getVERSION());
        entity.setIsActive(dto.isIS_ACTIVE());

        entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        entity.setModifiedDatetime(dto.getMODIFIED_DATETIME());

        entity.setInactive(false);
        entity.setToBeDeleted(false);
        // TODO: set from salary details data
        entity.setLimitToSixG(false);

        return entity;
    }

    private static BigDecimal toBigDecimal(Double value) {
        return value != null ? BigDecimal.valueOf(value) : null;
    }
}
