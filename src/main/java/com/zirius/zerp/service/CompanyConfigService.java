package com.zirius.zerp.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.zirius.zerp.Util;
import com.zirius.zerp.dto.CompanyDetailsDTO;
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
import com.zirius.zerp.model.salary.StandardSalaryCodeDetails;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        // toEntity modifies objectNode by adding fields
                        SalaryGroup dto = mapper.treeToValue(objectNode, SalaryGroup.class);
                        SalaryGroupObject entity = SalaryGroupMapper.toEntity(dto, companyId, companyConfigRepository, objectNode);

                        entities.add(entity);
                    }
                }
            }

            // 💡 Save updated root back into the map so that changes are reflected
            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Updated Salary Group Objects: " + entities);
            return entities;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update SalaryGroupObject for companyId: " + companyId, e);
        }
    }



    public List<SalaryReportingCodeDetails> updateSalaryReportingCodeDetails(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode salaryCode = root.get("salaryCodes");
            JsonNode salaryCodeAmessage = root.get("salaryReportingCodeAmessages");
            JsonNode salaryCodeBasis = root.get("salaryReportingCodeBases");

            List<StandardSalaryCodeDetails> standardSalaryCodeDetails = companyConfigRepository.getStandardSalaryReportingCodeDetails();
            Map<String, StandardSalaryCodeDetails> standardCodeMap = standardSalaryCodeDetails.stream()
                    .collect(Collectors.toMap(
                            StandardSalaryCodeDetails::getSalaryReportingCode,
                            Function.identity()
                    ));

            List<SalaryReportingCodeBasis> salaryCodeBasisList = new ArrayList<>();
            List<SalaryReportingCodeAmessage> salaryCodeAMessageList = new ArrayList<>();

            if (salaryCodeBasis != null && salaryCodeBasis.isArray()) {
                for (JsonNode basis : salaryCodeBasis) {
                    SalaryReportingCodeBasis codeBasis = mapper.treeToValue(basis, SalaryReportingCodeBasis.class);
                    salaryCodeBasisList.add(codeBasis);
                }
            }


            if (salaryCodeAmessage != null && salaryCodeAmessage.isArray()) {
                for (JsonNode aMessage : salaryCodeAmessage) {
                    SalaryReportingCodeAmessage codeAmessage = mapper.treeToValue(aMessage, SalaryReportingCodeAmessage.class);
                    salaryCodeAMessageList.add(codeAmessage);
                }
            }

            List<SalaryReportingCodeDetails> entities = new ArrayList<>();

            if (salaryCode != null && salaryCode.isArray()) {
                for (JsonNode node : salaryCode) {
                    if (node instanceof ObjectNode objectNode) {
                        objectNode.remove("id");

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        SalaryReportingCode dto = mapper.treeToValue(objectNode, SalaryReportingCode.class);

                        System.out.println("SalaryReportingCode **********************" + dto.getSalaryReportingCode());

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


                        SalaryReportingCodeDetails entity = SalaryReportingCodeMapper.toEntity(dto, companyId, codeBasis, codeMessage, companyConfigRepository, objectNode, standardCodeMap);
                        entities.add(entity);
                    }
                }
            }

            // Update root JSON into companyDataMap
            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Updated Salary Reporting Code Details: " + entities);
            return entities;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update SalaryReportingCodeDetails for companyId: " + companyId, e);
        }
    }



    public List<WorkPlaceObject> updateWorkPlaceObject(Integer companyId, Map<String, Object> companyDataMap, CompanyDetailsDTO companyDetailsDTO) {

        List<WorkPlaceObject> workPlaceObjects = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("companyWorkPlaces");



            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {
                        ((ObjectNode) node).remove("id");

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");


                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        CompanyWorkPlace dto = mapper.treeToValue(node, CompanyWorkPlace.class);


                        WorkPlaceObject result = CompanyWorkPlaceMapper.toEntity(dto, companyId,
                                companyConfigRepository, objectNode);
                        workPlaceObjects.add(result);
                    }

                }
            }


            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);


            System.out.println("Updated Work Place Objects: " + workPlaceObjects);

            return workPlaceObjects;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update WorkPlaceObject for companyId: " + companyId, e);
        }
    }


    public List<WorkPlaceMunicipalityObject> updateWorkPLaceMunicipality(Integer companyId, Map<String, Object> companyDataMap) {

        List<WorkPlaceMunicipalityObject> workPlaceMunicipality = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode workPlace = root.get("companyWorkPlaces");
            JsonNode municipality = root.get("workPlaceMunicipalities");

            List<WorkPlaceObject> workPlaceObjects = companyConfigRepository.getWorkPlaceList(companyId);

            List<CompanyWorkPlace> workPlaceObjectList = new ArrayList<>();

            if (workPlace != null && workPlace.isArray()) {
                for (JsonNode node : workPlace) {
                    if (node instanceof ObjectNode objectNode) {

//                        objectNode.remove("ziriusId");
//                        objectNode.remove("isUpdated");

                        CompanyWorkPlace dto = mapper.treeToValue(node, CompanyWorkPlace.class);
                        workPlaceObjectList.add(dto);
                    }
                }
            }

            if (municipality != null && municipality.isArray()) {
                for (JsonNode node : municipality) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        CompanyWorkPlaceMunicipality dto = mapper.treeToValue(node, CompanyWorkPlaceMunicipality.class);
                        CompanyWorkPlace companyWorkPlace = workPlaceObjectList.stream()
                                .filter(f -> f.getWORK_PLACE_ID().equals(dto.getWORK_PLACE_ID()))
                                .findFirst()
                                .orElse(null);

                        WorkPlaceObject wp = workPlaceObjects.stream().filter(f -> f.getWorkPlaceId().equals(companyWorkPlace.getZiriusId()))
                                .findFirst().orElse(null);

                        WorkPlaceMunicipalityObject workPlaceMunicipalityObject = CompanyWorkPlaceMunicipalityMapper.toEntity(dto, wp, companyId, companyConfigRepository, objectNode);
                        workPlaceMunicipality.add(workPlaceMunicipalityObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Work Place Municipality Updated" + workPlaceMunicipality);

            return workPlaceMunicipality;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update work Place Municipality data for companyId: " + companyId, e);
        }
    }

    public CompanySalaryDetailsObject updateCompanySalaryDetails(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("companySalaryDetails");

            CompanySalaryDetailsObject entity = new CompanySalaryDetailsObject();
            if (groupsNode != null) {
                if (groupsNode instanceof ObjectNode objectNode) {

                    JsonNode ziriusIdNode = objectNode.get("ziriusId");
                    JsonNode isUpdatedNode = objectNode.get("isUpdated");

                    if (ziriusIdNode == null && isUpdatedNode == null) {

                        CompanySalaryDetails dto = mapper.treeToValue(groupsNode, CompanySalaryDetails.class);
                        entity = CompanySalaryDetailsMapper.toEntity(dto, companyId, companyConfigRepository, objectNode);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Company salary details Updated" + entity);

            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update CompanySalaryDetailsObject for companyId: " + companyId, e);
        }
    }


    public List<CompanyFreeCarDetailsObject> updateFreeCarDetailsObject(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("companyFreeCarDetails");


            List<CompanyFreeCarDetailsObject> entities = new ArrayList<>();


            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }


                        CompanyFreeCarDetails dto = mapper.treeToValue(node, CompanyFreeCarDetails.class);

                        CompanyFreeCarDetailsObject detailsObject = CompanyFreeCarDetailsMapper.toEntity(dto, companyId, companyConfigRepository, objectNode);
                        entities.add(detailsObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Company free car details Updated" + entities);


            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update CompanyFreeCarDetailsObject for companyId: " + companyId, e);
        }
    }


    public List<CompanyFreeCarInsuranceObject> updateFreeCarInsuranceObject(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("companyFreeCarInsurances");
            JsonNode freeCarDetailsNode = root.get("companyFreeCarDetails");

            List<CompanyFreeCarDetails> carDetails = new ArrayList<>();
            List<CompanyFreeCarDetailsObject> ziriusCarDetails = companyConfigRepository.getCompanyFreeCarDetails(companyId);

            if (freeCarDetailsNode != null && freeCarDetailsNode.isArray()) {
                for (JsonNode node : freeCarDetailsNode) {
                    CompanyFreeCarDetails details = mapper.treeToValue(node, CompanyFreeCarDetails.class);
                    carDetails.add(details);
                }
            }


            List<CompanyFreeCarInsuranceObject> entities = new ArrayList<>();

            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        CompanyFreeCarInsurance dto = mapper.treeToValue(node, CompanyFreeCarInsurance.class);
                        CompanyFreeCarDetails freeCar = carDetails.stream().filter(f -> f.getCOMPANY_FREE_CAR_INSURANCE_ID() == dto.getCOMPANY_FREE_CAR_INSURANCE_ID()).findFirst().get();
                        CompanyFreeCarDetailsObject freeCarObject = ziriusCarDetails.stream().filter(f -> f.getCompanyFreeCarDetailsId().equals(freeCar.getZiriusId())).findFirst().get();
                        CompanyFreeCarInsuranceObject insuranceObject = CompanyFreeCarInsuranceMapper.toEntity(dto, freeCarObject, companyId, companyConfigRepository, objectNode);

                        entities.add(insuranceObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Free car Insurance updated" + entities);

            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update CompanyFreeCarInsuranceObject for companyId: " + companyId, e);
        }
    }


    public List<CompanyFreeCarSettingsObject> updateCompanyFreeCarSettingsObject(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("companyFreeCarSettings");
            JsonNode freeCarDetailsNode = root.get("companyFreeCarDetails");

            List<CompanyFreeCarDetails> carDetails = new ArrayList<>();
            List<CompanyFreeCarDetailsObject> ziriusCarDetails = companyConfigRepository.getCompanyFreeCarDetails(companyId);

            if (freeCarDetailsNode != null && freeCarDetailsNode.isArray()) {
                for (JsonNode node : freeCarDetailsNode) {
                    CompanyFreeCarDetails details = mapper.treeToValue(node, CompanyFreeCarDetails.class);
                    carDetails.add(details);
                }
            }

            List<CompanyFreeCarSettingsObject> entities = new ArrayList<>();

            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        CompanyFreeCarSetting settings = mapper.treeToValue(node, CompanyFreeCarSetting.class);
                        CompanyFreeCarDetails freeCar = carDetails.stream().filter(f -> f.getCOMPANY_FREE_CAR_SETTINGS_ID() == settings.getCOMPANY_FREE_CAR_SETTINGS_ID()).findFirst().get();
                        CompanyFreeCarDetailsObject freeCarObject = ziriusCarDetails.stream().filter(f -> f.getCompanyFreeCarDetailsId().equals(freeCar.getZiriusId())).findFirst().get();
                        CompanyFreeCarSettingsObject freeCarSettingsObject = CompanyFreeCarSettingsMapper.toEntity(settings, freeCarObject, companyId, companyConfigRepository, objectNode);
                        entities.add(freeCarSettingsObject);
                    }
                }

            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Free car settings updated" + entities);

            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update CompanyFreeCarSettingsObject for companyId: " + companyId, e);
        }
    }

    public List<CompanyFreeCarBenefitsObject> updateCompanyFreeCarBenefitsObject(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("companyFreeCarBenefits");
            JsonNode freeCarDetailsNode = root.get("companyFreeCarDetails");

            List<CompanyFreeCarDetails> carDetails = new ArrayList<>();
            List<CompanyFreeCarDetailsObject> ziriusCarDetails = companyConfigRepository.getCompanyFreeCarDetails(companyId);

            if (freeCarDetailsNode != null && freeCarDetailsNode.isArray()) {
                for (JsonNode node : freeCarDetailsNode) {
                    CompanyFreeCarDetails details = mapper.treeToValue(node, CompanyFreeCarDetails.class);
                    carDetails.add(details);
                }
            }


            List<CompanyFreeCarBenefitsObject> entities = new ArrayList<>();

            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        CompanyFreeCarBenefits dto = mapper.treeToValue(node, CompanyFreeCarBenefits.class);
                        CompanyFreeCarDetails freeCar = carDetails.stream().filter(f -> f.getCOMPANY_FREE_CAR_BENEFITS_ID() == dto.getCompanyFreeCarBenefitId()).findFirst().get();
                        CompanyFreeCarDetailsObject freeCarObject = ziriusCarDetails.stream().filter(f -> f.getCompanyFreeCarDetailsId().equals(freeCar.getZiriusId())).findFirst().get();
                        CompanyFreeCarBenefitsObject benefitsObject = CompanyFreeCarBenefitsMapper.toEntity(dto, freeCarObject, companyId, companyConfigRepository, objectNode);
                        entities.add(benefitsObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Free car Benefits updated" + entities);

            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update CompanyFreeCarBenefitsObject for companyId: " + companyId, e);
        }
    }


    public List<SalaryYearlyConstantsConfigObject> updateYearlyConstantConfig(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupsNode = root.get("yearlyConstants");
            JsonNode salaryDetailsNode = root.get("companySalaryDetails");

            CompanySalaryDetails salaryDetails = new CompanySalaryDetails();
            List<SalaryYearlyConstantsConfigObject> entities = new ArrayList<>();

            if (salaryDetailsNode != null) {
                if (salaryDetailsNode instanceof ObjectNode objectNode) {
                    salaryDetails = mapper.treeToValue(salaryDetailsNode, CompanySalaryDetails.class);
                }
            }

            if (groupsNode != null && groupsNode.isArray()) {
                for (JsonNode node : groupsNode) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        SalaryYearlyConstant dto = mapper.treeToValue(node, SalaryYearlyConstant.class);
                        SalaryYearlyConstantsConfigObject configObject = SalaryYearlyConstantsMapper.toEntity(dto, salaryDetails, companyId, companyConfigRepository, objectNode);
                        entities.add(configObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Yearly constants updated" + entities);

            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update SalaryYearlyConstantsConfigObject for companyId: " + companyId, e);
        }
    }


    public List<ClaimCollectorsDetailsObject> updateClaimCollectorDetails(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode claimCollectors = root.get("claimCollectorDetails");
            JsonNode claimCollectorValues = root.get("claimCollectorValues");

            List<ClaimCollectorsDetailsObject> entities = new ArrayList<>();
            List<ClaimCollectorValues> claimValuesList = new ArrayList<>();


            if (claimCollectorValues != null && claimCollectorValues.isArray()) {
                for (JsonNode node : claimCollectorValues) {
                    ClaimCollectorValues dto = mapper.treeToValue(node, ClaimCollectorValues.class);
                    claimValuesList.add(dto);
                }
            }

            if (claimCollectors != null && claimCollectors.isArray()) {
                for (JsonNode node : claimCollectors) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        ClaimCollectorDetails dto = mapper.treeToValue(node, ClaimCollectorDetails.class);
                        ClaimCollectorValues claimValue = claimValuesList.stream().filter(f ->
                                f.getCLAIM_COLLECTORS_VALUES_ID().equals(dto.getCLAIM_COLLECTORS_VALUES_ID())).findFirst().get();

                        ClaimCollectorsDetailsObject detailsObject = ClaimCollectorsDetailsMapper.toEntity(dto, companyId, claimValue, companyConfigRepository, objectNode);
                        entities.add(detailsObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Claim Collector Details Updated" + entities);

            return entities;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update ClaimCollectorsDetailsObject for companyId: " + companyId, e);
        }
    }

    public List<CompanyPensionOtpObject> updateCompanyPensionOtpObject(Integer companyId, Map<String, Object> companyDataMap) {
        try {
            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.convertValue(companyDataMap.get("companyConfigDTO"), JsonNode.class);
            JsonNode groupNode = root.get("companyPensionOTPS");

            List<CompanyPensionOtpObject> resultList = new ArrayList<>();

            if (groupNode != null && groupNode.isArray()) {
                for (JsonNode node : groupNode) {
                    if (node instanceof ObjectNode objectNode) {

                        JsonNode ziriusIdNode = objectNode.get("ziriusId");
                        JsonNode isUpdatedNode = objectNode.get("isUpdated");

                        if (ziriusIdNode != null && !ziriusIdNode.isNull() &&
                                isUpdatedNode != null && "true".equalsIgnoreCase(isUpdatedNode.asText())) {
                            continue;
                        }

                        CompanyPensionOTP dto = mapper.treeToValue(node, CompanyPensionOTP.class);
                        CompanyPensionOtpObject otpObject = CompanyPensionOtpMapper.toEntity(dto, companyId, companyConfigRepository, objectNode);
                        resultList.add(otpObject);
                    }
                }
            }

            Map<String, Object> updatedCompanyConfigDTO = mapper.convertValue(root, new TypeReference<>() {});
            companyDataMap.put("companyConfigDTO", updatedCompanyConfigDTO);

            System.out.println("Claim Collector Details Updated" + resultList);


            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update CompanyPensionOtpObject for companyId: " + companyId, e);
        }
    }


}
