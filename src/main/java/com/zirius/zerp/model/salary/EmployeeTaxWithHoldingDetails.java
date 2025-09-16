package com.zirius.zerp.model.salary;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;


@Entity
@Data
@Table(name = "emp_tax_withholding_details", schema = "salary")
public class EmployeeTaxWithHoldingDetails {

    public static final String PROPERTYNAME_salary_employee_tax_withholding_details_id = "salary_employee_tax_withholding_details_id";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_salary_employee_tax_details_id = "salary_employee_tax_details_id";
    public static final String PROPERTYNAME_salary_altinn_tax_code_id = "salary_altinn_tax_code_id";
    public static final String PROPERTYNAME_table_type_id = "table_type_id";
    public static final String PROPERTYNAME_table_number = "table_number";
    public static final String PROPERTYNAME_no_of_months_for_drawing = "no_of_months_for_drawing";
    public static final String PROPERTYNAME_tax_card_exemption_amount = "tax_card_exemption_amount";
    public static final String PROPERTYNAME_percentage = "percentage";

    @Id
    private int salary_employee_tax_withholding_details_id;
    private int company_id=0;
    private int salary_employee_tax_details_id;
    private int salary_altinn_tax_code_id;
    private int table_type_id;
    private String table_number;
    private BigDecimal no_of_months_for_drawing = new BigDecimal("0");
    private BigDecimal tax_card_exemption_amount = new BigDecimal("0");
    private BigDecimal percentage = new BigDecimal("0");
}
