package com.zirius.zerp.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.Util;
import com.zirius.zerp.model.salary.SalaryGroupObject;
import com.zirius.zerp.model.zerp.SalaryGroup;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Optional;

public class SalaryGroupMapper {

    private static Util util;

    public static SalaryGroupObject toEntity(SalaryGroup dto, Integer companyId, CompanyConfigRepository repo, ObjectNode jsonNode) {
        // Check if already updated
        JsonNode ziriusIdNode = jsonNode.get("ziriusId");
        JsonNode isUpdatedNode = jsonNode.get("isUpdated");

        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
            return null;
        }

        SalaryGroupObject entity = new SalaryGroupObject();

        entity.setVersion(dto.getVersion());
        entity.setSalaryGroupNo(dto.getSALARY_GROUP_NO());
        entity.setSalaryGroupName(dto.getSALARY_GROUP_NAME());

        entity.setSalaryGroupHours1(Optional.ofNullable(dto.getSALARY_GROUP_HOURS1()).orElse(BigDecimal.ZERO));
        entity.setSalaryGroupHours2(Optional.ofNullable(dto.getSALARY_GROUP_HOURS2()).orElse(BigDecimal.ZERO));
        entity.setSalaryGroupHours3(Optional.ofNullable(dto.getSALARY_GROUP_HOURS3()).orElse(BigDecimal.ZERO));
        entity.setSalaryGroupHours4(Optional.ofNullable(dto.getSALARY_GROUP_HOURS4()).orElse(BigDecimal.ZERO));
        entity.setSalaryGroupHours5(Optional.ofNullable(dto.getSALARY_GROUP_HOURS5()).orElse(BigDecimal.ZERO));
        entity.setSalaryGroupHoursFte(dto.getSALARY_GROUP_HOURS_FTE());

        if (dto.getSALARY_GROUP_LPA_DATE() != null) {
            entity.setSalaryGroupLpaDate(dto.getSALARY_GROUP_LPA_DATE());
        }

        entity.setHolidayPayPercent(dto.getHolidayPayPercent());
        entity.setHolidayPayPercentOver60(dto.getHolidayPayPercentOver60());
        entity.setDeviantHolidayPayPercent(Boolean.TRUE.equals(dto.getDEVIANT_HOLIDAY_PAY_PERCENT()));
        entity.setIsReportingSickness(Boolean.TRUE.equals(dto.getIS_REPORTING_SICKNESS()));
        entity.setIsActive(Boolean.TRUE.equals(dto.getIsActive()));
        entity.setIsDeleted(Boolean.TRUE.equals(dto.getIS_DELETED()));

        entity.setSalaryGroupCalendarTemplate(dto.getSALARY_GROUP_CALENDAR_TEMPLATE());
        entity.setSalaryGroupPayrollPerYear(dto.getSALARY_GROUP_PAYROLL_PER_YEAR());
        entity.setHolidayPercentUpdatedDate(dto.getHOLIDAY_PERCENT_UPDATED_DATE());
        entity.setCompanyId(companyId);
        entity.setHoursPerDay(dto.getHOURS_PER_DAY());
        entity.setDepartmentId(dto.getDepartmentId());

        if (dto.getCREATED_DATETIME() != null) {
            entity.setCreatedDatetime(dto.getCREATED_DATETIME());
        }
        if (dto.getModifiedDateTime() != null) {
            entity.setModifiedDatetime(dto.getModifiedDateTime());
        }

        // Save entity only if it hasn't been updated before
        repo.save(entity);

        if (entity.getSalaryGroupId() != null) {
            jsonNode.put("ziriusId", entity.getSalaryGroupId());
            jsonNode.put("isUpdated", "true");
        }

        return entity;
    }


    private static Util getUtil() {
        if (util == null) {
            util = new Util();
        }
        return util;
    }


}

