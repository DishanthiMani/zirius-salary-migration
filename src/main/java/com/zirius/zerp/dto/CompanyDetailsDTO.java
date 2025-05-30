package com.zirius.zerp.dto;

import com.zirius.zerp.model.erp.FirmaObject;
import com.zirius.zerp.model.salary.ClaimCollectorsDetailsObject;
import com.zirius.zerp.model.salary.CompanyFreeCarBenefitsObject;
import com.zirius.zerp.model.salary.CompanyFreeCarDetailsObject;
import com.zirius.zerp.model.salary.CompanyFreeCarInsuranceObject;
import com.zirius.zerp.model.salary.CompanyFreeCarSettingsObject;
import com.zirius.zerp.model.salary.CompanyPensionOtpObject;
import com.zirius.zerp.model.salary.CompanySalaryDetailsObject;
import com.zirius.zerp.model.salary.SalaryGroupObject;
import com.zirius.zerp.model.salary.SalaryReportingCodeDetails;
import com.zirius.zerp.model.salary.SalaryYearlyConstantsConfigObject;
import com.zirius.zerp.model.salary.WorkPlaceMunicipalityObject;
import com.zirius.zerp.model.salary.WorkPlaceObject;
import lombok.Data;

import java.util.List;

@Data
public class CompanyDetailsDTO {

    private FirmaObject firmaObject;
    private List<SalaryGroupObject> salaryGroupObjects;
    private List<SalaryReportingCodeDetails> salaryReportingCodeDetails;
    private List<WorkPlaceObject> workPlaceObjects;
    private List<WorkPlaceMunicipalityObject> workPlaceMunicipalityObjects;
    private CompanySalaryDetailsObject companySalaryDetailsObject;
    private List<CompanyFreeCarDetailsObject> companyFreeCarDetails;
    private List<CompanyFreeCarInsuranceObject> companyFreeCarInsuranceObject;
    private List<CompanyFreeCarSettingsObject> companyFreeCarSettingsObject;
    private List<CompanyFreeCarBenefitsObject> companyFreeCarBenefitsObject;
    private List<SalaryYearlyConstantsConfigObject> yearlyConstantsConfigObjects;
    private List<ClaimCollectorsDetailsObject> claimCollectorsDetailsObjects;
    private List<CompanyPensionOtpObject> companyPensionOtpObjects;
}
