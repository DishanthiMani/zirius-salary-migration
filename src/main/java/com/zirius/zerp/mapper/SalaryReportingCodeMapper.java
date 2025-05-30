package com.zirius.zerp.mapper;

import com.zirius.zerp.model.salary.SalaryReportingCodeDetails;
import com.zirius.zerp.model.zerp.SalaryReportingCode;
import com.zirius.zerp.model.zerp.SalaryReportingCodeAmessage;
import com.zirius.zerp.model.zerp.SalaryReportingCodeBasis;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

public class SalaryReportingCodeMapper {

    public static SalaryReportingCodeDetails toEntity(SalaryReportingCode dto, Integer companyId, SalaryReportingCodeBasis
            codeBasis, SalaryReportingCodeAmessage codeAMessage) {
        SalaryReportingCodeDetails entity = new SalaryReportingCodeDetails();

        entity.setSalaryReportingCodeId(null);
        entity.setCompanyId(companyId);
        entity.setSalaryReportingCode(dto.getSalaryReportingCode());
        entity.setSalaryReportingCodeName(dto.getSalaryReportingCodeName());

        entity.setDebitAccountNo(Optional.ofNullable(dto.getAccountId()).map(Long::intValue).orElse(null));
        entity.setCreditAccountNo(Optional.ofNullable(dto.getCreditAccountId()).map(Long::intValue).orElse(null));
        entity.setSalaryTypeId(Optional.ofNullable(dto.getTypeId()).map(Long::intValue).orElse(null));

        entity.setCostPrice(Optional.ofNullable(dto.getCostPrice()).map(BigDecimal::valueOf).orElse(BigDecimal.ZERO));
        entity.setSalePrice(Optional.ofNullable(dto.getSalePrice()).map(BigDecimal::valueOf).orElse(BigDecimal.ZERO));

        entity.setIsActive(Boolean.TRUE.equals(dto.getIsActive()));


        entity.setSalaryDescription(codeAMessage.getSALARY_DESCRIPTION());
        entity.setBenefits(codeAMessage.getBENEFITS());
        entity.setIsSpecification(codeAMessage.getIS_SPECIFICATION());
        entity.setIsHolidayPay(codeBasis.getIS_HOLIDAY_PAY());
        entity.setIsPayrollTax(codeBasis.getIS_PAYROLL_TAX());
        entity.setIsUnion(codeBasis.getIS_UNION());
        entity.setTaxesId(codeBasis.getTAXES_ID());
        entity.setPensionId(codeBasis.getPENSION_ID());
        entity.setSsbId(codeBasis.getSSB_ID());
        entity.setIsPension(codeBasis.getIS_PENSION());
        entity.setSalaryCodeRateTypeId(codeBasis.getSALARY_CODE_RATE_TYPE_ID());
        entity.setSalaryCodeYearlyRateTypeId(codeBasis.getSALARY_CODE_YEARLY_RATE_TYPE_ID());

        entity.setVersion(dto.getVersion());


        entity.setCreatedDatetime(convertToLocalDateTime(dto.getCreatedDateTime()));
        entity.setModifiedDatetime(convertToLocalDateTime(dto.getModifiedDateTime()));

        entity.setInactive(false);
        entity.setToBeDeleted(false);

        return entity;
    }

    private static LocalDateTime convertToLocalDateTime(Date date) {
        return date == null ? null : date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
