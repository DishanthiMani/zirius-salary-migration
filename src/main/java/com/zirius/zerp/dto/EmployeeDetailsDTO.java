package com.zirius.zerp.dto;

import com.zirius.zerp.model.erp.app_userObject;
import com.zirius.zerp.model.erp.company_userObject;
import com.zirius.zerp.model.salary.EmployeeAppointments;
import com.zirius.zerp.model.salary.EmployeePermissionObject;
import com.zirius.zerp.model.salary.EmployeeSalaryAccounts;
import com.zirius.zerp.model.salary.EmployeeSalaryConfig;
import com.zirius.zerp.model.salary.EmployeeSalaryReportingCode;
import com.zirius.zerp.model.salary.EmployeeStartUpCodeObject;
import com.zirius.zerp.model.salary.EmployeeStartUpDetailsObject;
import com.zirius.zerp.model.salary.EmployeeTaxDeduction;

import com.zirius.zerp.model.salary.EmployeeWorkPlace;
import lombok.Data;

import java.util.List;

@Data
public class EmployeeDetailsDTO {


    private app_userObject appUserObject;
    private company_userObject companyUserObject;
    private EmployeeSalaryAccounts empSalaryAccount;
    private EmployeeTaxDeduction employeeTaxDeduction;
    private EmployeeStartUpDetailsObject employeeStartUpDetails;
    private List<EmployeeStartUpCodeObject> employeeStartUpSalaryCodeList;
    private EmployeeAppointments employeeAppointments;
    private List<EmployeeWorkPlace> empWorkPlaceList;
    private EmployeeSalaryConfig empSalaryConfig;
    private List<EmployeeSalaryReportingCode> empCodeList;
    private List<EmployeePermissionObject> employeePermissionObjects;

}
