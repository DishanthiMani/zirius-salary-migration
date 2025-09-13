package com.zirius.zerp.dto;

import com.zirius.zerp.model.erp.app_userObject;
import com.zirius.zerp.model.erp.company_userObject;
import lombok.Data;

@Data
public class EmployeeDetailsDTO {


    private app_userObject appUserObject;
    private company_userObject companyUserObject;


}
