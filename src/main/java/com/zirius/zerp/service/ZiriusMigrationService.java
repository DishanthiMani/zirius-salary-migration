package com.zirius.zerp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zirius.zerp.dto.CompanyDetailsDTO;
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
import com.zirius.zerp.model.zerp.CompanySalaryDetails;
import com.zirius.zerp.repository.erp.ErpGeneralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZiriusMigrationService {


    @Autowired
    private ErpGeneralRepository configRepo;

    @Autowired
    private CompanyConfigService configService;


    public boolean updateCompanyData(String organizationNumber, String path) throws Exception{
        Map<String, Object> companyDataMap = null;

        try {
            CompanyDetailsDTO companyDetailsDTO = new CompanyDetailsDTO();
            companyDataMap = getJSONFileDataForCompany(organizationNumber, path);

            FirmaObject companyObject = configRepo.getFirmaObjectData((String) companyDataMap.get("organizationNumber"));
            List<SalaryGroupObject> salaryGroupObject = configService.updateSalaryGroupObject(companyObject.getCOMPANY_ID(), companyDataMap);
            List<SalaryReportingCodeDetails> salaryReportingCodeDetails = configService.updateSalaryReportingCodeDetails(companyObject.getCOMPANY_ID(), companyDataMap);
            List<WorkPlaceObject> workPlaceObjects = configService.updateWorkPlaceObject(companyObject.getCOMPANY_ID(), companyDataMap);
            List<WorkPlaceMunicipalityObject> workPlaceMunicipality = configService.updateWorkPlaceMunicipalityObject(companyObject.getCOMPANY_ID(), companyDataMap, workPlaceObjects);
            CompanySalaryDetailsObject companySalaryDetails = configService.updateCompanySalaryDetails(companyObject.getCOMPANY_ID(), companyDataMap);
            List<CompanyFreeCarInsuranceObject> companyFreeCarInsurance = configService.updateFreeCarInsuranceObject(companyObject.getCOMPANY_ID(), companyDataMap);
            List<CompanyFreeCarSettingsObject> companyFreeCarSettingsObjects = configService.updateCompanyFreeCarSettingsObject(companyObject.getCOMPANY_ID(), companyDataMap);
            List<CompanyFreeCarBenefitsObject> companyFreeCarBenefitsObjects = configService.updateCompanyFreeCarBenefitsObject(companyObject.getCOMPANY_ID(), companyDataMap);
            List<CompanyFreeCarDetailsObject> companyFreeCarDetailsObjects = configService.updateFreeCarDetailsObject(companyObject.getCOMPANY_ID(), companyDataMap);
            List<SalaryYearlyConstantsConfigObject> salaryYearlyConfigObject = configService.updateYearlyConstantConfig(companyObject.getCOMPANY_ID(), companyDataMap);
            List<ClaimCollectorsDetailsObject> claimCollectorDetails = configService.updateClaimCollectorDetails(companyObject.getCOMPANY_ID(), companyDataMap);
            List<CompanyPensionOtpObject> companyPensionOtpObjects = configService.updateCompanyPensionOtpObject(companyObject.getCOMPANY_ID(), companyDataMap);

            companyDetailsDTO.setFirmaObject(companyObject);
            companyDetailsDTO.setSalaryGroupObjects(salaryGroupObject);
            companyDetailsDTO.setSalaryReportingCodeDetails(salaryReportingCodeDetails);
            companyDetailsDTO.setWorkPlaceObjects(workPlaceObjects);
            companyDetailsDTO.setWorkPlaceMunicipalityObjects(workPlaceMunicipality);
            companyDetailsDTO.setCompanySalaryDetailsObject(companySalaryDetails);
            companyDetailsDTO.setCompanyFreeCarDetails(companyFreeCarDetailsObjects);
            companyDetailsDTO.setCompanyFreeCarInsuranceObject(companyFreeCarInsurance);
            companyDetailsDTO.setCompanyFreeCarSettingsObject(companyFreeCarSettingsObjects);
            companyDetailsDTO.setCompanyFreeCarBenefitsObject(companyFreeCarBenefitsObjects);
            companyDetailsDTO.setYearlyConstantsConfigObjects(salaryYearlyConfigObject);
            companyDetailsDTO.setClaimCollectorsDetailsObjects(claimCollectorDetails);
            companyDetailsDTO.setCompanyPensionOtpObjects(companyPensionOtpObjects);

            System.out.println("****CompanyConfigObject****" + companyDetailsDTO);

            return true;
        } catch (Exception e) {
            if (companyDataMap != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(companyDataMap);

                String fallbackOrgNo = (String) companyDataMap.get("organizationNumber");
                String fileName = "E:\\Migration_docs\\" + fallbackOrgNo + ".json";

                Files.write(
                        Paths.get(fileName),
                        json.getBytes(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING
                );
            }
            e.printStackTrace();
            return false;
        }
    }




    public Map<String, Object> getJSONFileDataForCompany(String organizationNumber, String path) {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<>();

        try {
            // Check for null or empty path
            if (path == null || path.trim().isEmpty()) {
                path = "E:/Migration_docs/" + organizationNumber + ".json";
            }

            File file = new File(path);

            // Optional: check if file exists before reading
            if (!file.exists()) {
                throw new FileNotFoundException("File not found at path: " + path);
            }

            jsonMap = mapper.readValue(file, Map.class);
            System.out.println(jsonMap);
            return jsonMap;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("The expected file was not found or failed to read", e);
        }
    }
}


