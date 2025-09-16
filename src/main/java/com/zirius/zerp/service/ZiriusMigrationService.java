package com.zirius.zerp.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zirius.zerp.dto.CompanyDetailsDTO;
import com.zirius.zerp.dto.EmployeeDetailsDTO;
import com.zirius.zerp.model.erp.FirmaObject;
import com.zirius.zerp.model.erp.app_userObject;
import com.zirius.zerp.model.erp.company_userObject;
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
import com.zirius.zerp.repo.SalaryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ZiriusMigrationService {


    @Autowired
    private SalaryRepo configRepo;

    @Autowired
    private CompanyConfigService configService;

    @Autowired
    private EmployeeConfigService empConfService;


    public boolean updateCompanyData(String companyId, String path) throws Exception {
        Map<String, Object> companyDataMap = null;

        try {

            configRepo = new SalaryRepo(companyId);
            companyDataMap = getJSONFileDataForCompany(companyId, path);
            FirmaObject companyObject = configRepo.getFirmaObjectData();
            CompanyDetailsDTO companyDetailsDTO = updateCompanyConfiguration(companyObject, companyDataMap);
            List<EmployeeDetailsDTO> empDetails = updateEmployeeConfiguration(companyObject, companyDataMap, companyDetailsDTO);

            if (companyDataMap != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(companyDataMap);

//                String fallbackOrgNo = (String) companyDataMap.get("organizationNumber");
                String fileName = "E:\\Migration_docs\\" + companyId + ".json";

                Files.write(
                        Paths.get(fileName),
                        json.getBytes(),
                        StandardOpenOption.CREATE,
                        StandardOpenOption.TRUNCATE_EXISTING
                );
            }

            return true;
        } catch (Exception e) {
            if (companyDataMap != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(companyDataMap);

//                String fallbackOrgNo = (String) companyDataMap.get("organizationNumber");
                String fileName = "E:\\Migration_docs\\" + companyId + ".json";

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


    @Transactional
    public CompanyDetailsDTO updateCompanyConfiguration(FirmaObject companyObject, Map<String, Object> companyDataMap) {

        try {

            CompanyDetailsDTO companyDetailsDTO = new CompanyDetailsDTO();
            List<SalaryGroupObject> salaryGroupObject = configService.updateSalaryGroupObject(companyObject.getCompany_id(), companyDataMap);
            List<SalaryReportingCodeDetails> salaryReportingCodeDetails = configService.updateSalaryReportingCodeDetails(companyObject.getCompany_id(), companyDataMap);
            List<WorkPlaceObject> workPlaceObjects = configService.updateWorkPlaceObject(companyObject.getCompany_id(), companyDataMap, companyDetailsDTO);
            List<WorkPlaceMunicipalityObject> workPlaceMunicipality = configService.updateWorkPLaceMunicipality(companyObject.getCompany_id(), companyDataMap);
            CompanySalaryDetailsObject companySalaryDetails = configService.updateCompanySalaryDetails(companyObject.getCompany_id(), companyDataMap);
            List<CompanyFreeCarDetailsObject> companyFreeCarDetailsObjects = configService.updateFreeCarDetailsObject(companyObject.getCompany_id(), companyDataMap);
            List<CompanyFreeCarSettingsObject> companyFreeCarSettingsObjects = configService.updateCompanyFreeCarSettingsObject(companyObject.getCompany_id(), companyDataMap);
            List<CompanyFreeCarBenefitsObject> companyFreeCarBenefitsObjects = configService.updateCompanyFreeCarBenefitsObject(companyObject.getCompany_id(), companyDataMap);
            List<CompanyFreeCarInsuranceObject> companyFreeCarInsurance = configService.updateFreeCarInsuranceObject(companyObject.getCompany_id(), companyDataMap);
            List<SalaryYearlyConstantsConfigObject> salaryYearlyConfigObject = configService.updateYearlyConstantConfig(companyObject.getCompany_id(), companyDataMap);
            List<ClaimCollectorsDetailsObject> claimCollectorDetails = configService.updateClaimCollectorDetails(companyObject.getCompany_id(), companyDataMap);
            List<CompanyPensionOtpObject> companyPensionOtpObjects = configService.updateCompanyPensionOtpObject(companyObject.getCompany_id(), companyDataMap);

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
            return companyDetailsDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update company salary config" + e.getMessage());
        }

    }

    @Transactional
    public List<EmployeeDetailsDTO> updateEmployeeConfiguration(FirmaObject companyObject, Map<String, Object> companyDataMap, CompanyDetailsDTO companyDetailsDTO) {

        try {

//            List<app_userObject> appUserObjects = empConfService.updateAppUserList(companyObject, companyDataMap);
//            List<company_userObject> companyUserObjects = empConfService.updateCompanyUserList(companyObject, companyDataMap, appUserObjects);
            List<EmployeeDetailsDTO> employeeDetailsList = new ArrayList<>();
//            empConfService.updateEmployeeDetails(companyObject, companyDataMap, appUserObjects, companyUserObjects);


            return employeeDetailsList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update EmployeeConfiguration");
        }
    }


    public Map<String, Object> getJSONFileDataForCompany(String companyId, String path) {

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = new HashMap<>();

        try {
            // Check for null or empty path
            if (path == null || path.trim().isEmpty()) {
                path = "E:/Migration_docs/" + companyId + ".json";
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


