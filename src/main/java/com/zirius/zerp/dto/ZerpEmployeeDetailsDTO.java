package com.zirius.zerp.dto;


import com.zirius.zerp.model.zerp.AppUser;
import com.zirius.zerp.model.zerp.EmployeeAppointments;
import com.zirius.zerp.model.zerp.EmployeeStartUpDetails;
import com.zirius.zerp.model.zerp.EmployeeStartUpSalaryCode;
import com.zirius.zerp.model.zerp.EmployeeTaxDeduction;
import com.zirius.zerp.model.zerp.EmployeeWorkPlace;
import com.zirius.zerp.model.zerp.UserClaimDetils;
import com.zirius.zerp.model.zerp.UserCompany;
import com.zirius.zerp.model.zerp.UserCompanySalaryCode;
import com.zirius.zerp.model.zerp.UserCompanySalaryConfig;
import com.zirius.zerp.model.zerp.UserFreeCarDetails;
import lombok.Data;

import java.util.List;

@Data
public class ZerpEmployeeDetailsDTO {

    private AppUser appUser;
    private UserCompany userCompany;
    private EmployeeTaxDeduction empTaxDeduction;
    private EmployeeAppointments employeeAppointments;
    private List<EmployeeWorkPlace> employeeWorkPlaces;
    private EmployeeStartUpDetails employeeStartUpDetails;
    private List<EmployeeStartUpSalaryCode> empStartUpCodes;
    private UserCompanySalaryConfig userCompanySalaryConfig;
    private List<UserCompanySalaryCode> userCompanySalaryCodes;
    private List<UserFreeCarDetails> userFreeCarDetails;
    private List<UserClaimDetils> userClaimDetails;
}
