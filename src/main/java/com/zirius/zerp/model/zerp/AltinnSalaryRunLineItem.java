package com.zirius.zerp.model.zerp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
// @Entity
// @Table(name = "altinn_salary_run_line_item")
public class AltinnSalaryRunLineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ALTINN_SALARY_RUN_LINE_ITEM_ID;

    private Integer SALARY_RUN_ID;

    private String BUSINESS_NUMBER;

    private String user_ssn;

    private String international_id;

    private String ADVANTAGE;

    private BigDecimal AMOUNT;

    private Integer STATUS1;

    private Integer STATUS2;

    private String DESCRIPTION;

    private String SALARY_REPORTING_CODE;
}
