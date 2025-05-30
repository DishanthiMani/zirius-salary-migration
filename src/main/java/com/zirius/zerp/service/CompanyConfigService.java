package com.zirius.zerp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.Util;
import com.zirius.zerp.mapper.ClaimCollectorsDetailsMapper;
import com.zirius.zerp.mapper.CompanyFreeCarBenefitsMapper;
import com.zirius.zerp.mapper.CompanyFreeCarDetailsMapper;
import com.zirius.zerp.mapper.CompanyFreeCarInsuranceMapper;
import com.zirius.zerp.mapper.CompanyFreeCarSettingsMapper;
import com.zirius.zerp.mapper.CompanyPensionOtpMapper;
import com.zirius.zerp.mapper.CompanySalaryDetailsMapper;
import com.zirius.zerp.mapper.CompanyWorkPlaceMapper;
import com.zirius.zerp.mapper.CompanyWorkPlaceMunicipalityMapper;
import com.zirius.zerp.mapper.SalaryGroupMapper;
import com.zirius.zerp.mapper.SalaryReportingCodeMapper;
import com.zirius.zerp.mapper.SalaryYearlyConstantsMapper;
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
import com.zirius.zerp.model.zerp.ClaimCollectorDetails;
import com.zirius.zerp.model.zerp.ClaimCollectorValues;
import com.zirius.zerp.model.zerp.CompanyFreeCarBenefits;
import com.zirius.zerp.model.zerp.CompanyFreeCarDetails;
import com.zirius.zerp.model.zerp.CompanyFreeCarInsurance;
import com.zirius.zerp.model.zerp.CompanyFreeCarSetting;
import com.zirius.zerp.model.zerp.CompanyPensionOTP;
import com.zirius.zerp.model.zerp.CompanySalaryDetails;
import com.zirius.zerp.model.zerp.CompanyWorkPlace;
import com.zirius.zerp.model.zerp.CompanyWorkPlaceMunicipality;
import com.zirius.zerp.model.zerp.SalaryGroup;
import com.zirius.zerp.model.zerp.SalaryReportingCode;
import com.zirius.zerp.model.zerp.SalaryReportingCodeAmessage;
import com.zirius.zerp.model.zerp.SalaryReportingCodeBasis;
import com.zirius.zerp.model.zerp.SalaryYearlyConstant;
import com.zirius.zerp.repository.erp.ErpGeneralRepository;
import com.zirius.zerp.repository.salary.CompanyConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompanyConfigService {

    @Autowired
    private ErpGeneralRepository erpRepo;

    @Autowired
    private CompanyConfigRepository companyConfigRepository;



    public List<SalaryGroupObject> updateSalaryGroupObject(Integer companyId, Map<String, Object> companyDataMap) throws IOException {
        List<SalaryGroupObject> entities = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("salaryGroups");

            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {
                        objectNode.remove("id");
                        SalaryGroup dto = mapper.treeToValue(objectNode, SalaryGroup.class);
                        SalaryGroupObject entity = SalaryGroupMapper.toEntity(dto, companyId, companyConfigRepository, objectNode);
                        entities.add(entity);
                    }
                }
            }

            System.out.println("Salary Group Object " + entities);

            return entities;
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update SalaryGroupObject for companyId: " + companyId, e);
        }
    }



    public List<SalaryReportingCodeDetails> updateSalaryReportingCodeDetails(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode salaryCode = root.get("salaryCodeDetails");
            JsonNode salaryCodeAmessage = root.get("salaryReportingCodeAmessages");
            JsonNode salaryCodeBasis = root.get("salaryReportingCodeBases");

            List<SalaryReportingCode> salaryCodeList = new ArrayList<>();
            List<SalaryReportingCodeBasis> salaryCodeBasisList = new ArrayList<>();
            List<SalaryReportingCodeAmessage> salaryCodeAMessageList = new ArrayList<>();

            if (salaryCode != null && salaryCode.isArray()) {
                for (JsonNode code : salaryCode) {
                    SalaryReportingCode code1 = mapper.treeToValue(code, SalaryReportingCode.class);
                    salaryCodeList.add(code1);
                }
            }

            if (salaryCodeAmessage != null && salaryCodeAmessage.isArray()) {
                for (JsonNode aMessage : salaryCodeAmessage) {
                    SalaryReportingCodeAmessage codeAmessage = mapper.treeToValue(aMessage, SalaryReportingCodeAmessage.class);
                    salaryCodeAMessageList.add(codeAmessage);
                }
            }

            if (salaryCodeBasis != null && salaryCodeBasis.isArray()) {
                for (JsonNode basis : salaryCodeBasis) {
                    SalaryReportingCodeBasis codeBasis = mapper.treeToValue(basis, SalaryReportingCodeBasis.class);
                    salaryCodeBasisList.add(codeBasis);
                }
            }

            List<SalaryReportingCodeDetails> entities = salaryCodeList.stream()
                    .map(dto -> {
                        SalaryReportingCodeBasis codeBasis = salaryCodeBasisList.stream()
                                .filter(cv -> cv.getSALARY_REPORTING_CODE_ID().equals(dto.getSalaryReportingCodeId()))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException(
                                        "No matching salary code basis found for salaryCodeId: " + dto.getSalaryReportingCodeId()
                                ));
                        SalaryReportingCodeAmessage codeMessage = salaryCodeAMessageList.stream()
                                .filter(cm -> cm.getSALARY_REPORTING_CODE_ID().equals(dto.getSalaryReportingCodeId()))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException(
                                        "No matching salary code a message for salaryCodeId: " + dto.getSalaryReportingCodeId()
                                ));
                        return SalaryReportingCodeMapper.toEntity(dto, companyId, codeBasis, codeMessage);
                    })
                    .collect(Collectors.toList());

            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update SalaryReportingCodeDetails for companyId: " + companyId, e);
        }
    }


    public List<WorkPlaceObject> updateWorkPlaceObject(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("companyWorkPlaces");

        List<CompanyWorkPlace> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                CompanyWorkPlace dto = mapper.treeToValue(node, CompanyWorkPlace.class);
                dtoList.add(dto);
            }
        }

        List<WorkPlaceObject> entities = dtoList.stream()
                .map(dto -> CompanyWorkPlaceMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;
    }

    public List<WorkPlaceMunicipalityObject> updateWorkPlaceMunicipalityObject(Integer companyId, Map<String, Object> companyDataMap, List<WorkPlaceObject> workPlaceObjects) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("workPlaceMunicipalities");

        List<CompanyWorkPlaceMunicipality> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                CompanyWorkPlaceMunicipality dto = mapper.treeToValue(node, CompanyWorkPlaceMunicipality.class);
                dtoList.add(dto);
            }
        }

        List<WorkPlaceMunicipalityObject> entities = dtoList.stream()
                .map(dto -> CompanyWorkPlaceMunicipalityMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;

    }

    public CompanySalaryDetailsObject updateCompanySalaryDetails(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("companySalaryDetails");
        CompanySalaryDetailsObject entity = new CompanySalaryDetailsObject();
        if (groupsNode != null) {
            CompanySalaryDetails dto = mapper.treeToValue(groupsNode, CompanySalaryDetails.class);
            entity = CompanySalaryDetailsMapper.toEntity(dto, companyId);
        }

        return entity;
    }

    public List<CompanyFreeCarDetailsObject> updateFreeCarDetailsObject(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("companyFreeCarDetails");
        List<CompanyFreeCarDetails> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                CompanyFreeCarDetails dto = mapper.treeToValue(node, CompanyFreeCarDetails.class);
                dtoList.add(dto);
            }
        }

        List<CompanyFreeCarDetailsObject> entities = dtoList.stream()
                .map(dto -> CompanyFreeCarDetailsMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;
    }

    public List<CompanyFreeCarInsuranceObject> updateFreeCarInsuranceObject(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("companyFreeCarInsurances");
        List<CompanyFreeCarInsurance> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                CompanyFreeCarInsurance dto = mapper.treeToValue(node, CompanyFreeCarInsurance.class);
                dtoList.add(dto);
            }
        }

        List<CompanyFreeCarInsuranceObject> entities = dtoList.stream()
                .map(dto -> CompanyFreeCarInsuranceMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;
    }

    public List<CompanyFreeCarSettingsObject> updateCompanyFreeCarSettingsObject(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("companyFreeCarSettings");
        List<CompanyFreeCarSetting> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                CompanyFreeCarSetting dto = mapper.treeToValue(node, CompanyFreeCarSetting.class);
                dtoList.add(dto);
            }
        }

        List<CompanyFreeCarSettingsObject> entities = dtoList.stream()
                .map(dto -> CompanyFreeCarSettingsMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;
    }

    public List<CompanyFreeCarBenefitsObject> updateCompanyFreeCarBenefitsObject(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("companyFreeCarBenefits");
        List<CompanyFreeCarBenefits> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                CompanyFreeCarBenefits dto = mapper.treeToValue(node, CompanyFreeCarBenefits.class);
                dtoList.add(dto);
            }
        }

        List<CompanyFreeCarBenefitsObject> entities = dtoList.stream()
                .map(dto -> CompanyFreeCarBenefitsMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;
    }

    public List<SalaryYearlyConstantsConfigObject> updateYearlyConstantConfig(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);

        JsonNode groupsNode = root.get("yearlyConstants");
        List<SalaryYearlyConstant> dtoList = new ArrayList<>();
        if (groupsNode != null && groupsNode.isArray()) {
            for (JsonNode node : groupsNode) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                SalaryYearlyConstant dto = mapper.treeToValue(node, SalaryYearlyConstant.class);
                dtoList.add(dto);
            }
        }

        List<SalaryYearlyConstantsConfigObject> entities = dtoList.stream()
                .map(dto -> SalaryYearlyConstantsMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());

        return entities;
    }

    public List<ClaimCollectorsDetailsObject> updateClaimCollectorDetails(
            Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
        JsonNode claimCollectors = root.get("claimCollectorDetails");
        JsonNode claimCollectorValues = root.get("claimCollectorValues");

        List<ClaimCollectorDetails> dtoList = new ArrayList<>();
        List<ClaimCollectorValues> claimValuesList = new ArrayList<>();

        if (claimCollectorValues != null && claimCollectorValues.isArray()) {
            for (JsonNode node : claimCollectorValues) {
                ClaimCollectorValues dto = mapper.treeToValue(node, ClaimCollectorValues.class);
                claimValuesList.add(dto);
            }
        }

        if (claimCollectors != null && claimCollectors.isArray()) {
            for (JsonNode node : claimCollectors) {
                if (node instanceof ObjectNode) {
                    ((ObjectNode) node).remove("id");
                }
                ClaimCollectorDetails dto = mapper.treeToValue(node, ClaimCollectorDetails.class);
                dtoList.add(dto);
            }
        }

        List<ClaimCollectorsDetailsObject> entities = dtoList.stream()
                .map(dto -> {
                    ClaimCollectorValues matchedClaimValue = claimValuesList.stream()
                            .filter(cv -> cv.getCLAIM_COLLECTORS_VALUES_ID().equals(dto.getCLAIM_COLLECTORS_VALUES_ID()))
                            .findFirst()
                            .orElseThrow(() -> new RuntimeException(
                                    "No matching ClaimValue found for claimCollectorValuesId: " + dto.getCLAIM_COLLECTORS_VALUES_ID()
                            ));
                    return ClaimCollectorsDetailsMapper.toEntity(dto, companyId, matchedClaimValue);
                })
                .collect(Collectors.toList());

        return entities;
    }

    public List<CompanyPensionOtpObject> updateCompanyPensionOtpObject(Integer companyId, Map<String, Object> companyDataMap) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
        JsonNode groupNode = root.get("companyPensionOTPS");

        List<CompanyPensionOTP> dtoList = new ArrayList<>();
        if(groupNode != null && groupNode.isArray()) {
            for(JsonNode node : groupNode) {
                CompanyPensionOTP dto = mapper.treeToValue(node, CompanyPensionOTP.class);
                dtoList.add(dto);
            }
        }
        List<CompanyPensionOtpObject> resultList = dtoList.stream()
                .map(dto -> CompanyPensionOtpMapper.toEntity(dto, companyId))
                .collect(Collectors.toList());
        return resultList;
    }

}
