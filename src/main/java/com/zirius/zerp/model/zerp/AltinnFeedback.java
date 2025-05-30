package com.zirius.zerp.model.zerp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "altinn_feedback")
public class AltinnFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ALTINN_FEEDBACK_ID;

    private Integer SALARY_RUN_ID;

    private String BUSINESS_NUMBER;

    private String ssn;

    private String TYPE_OF_EMPLOYEE;

    private String ERROR_ID;

    private String ERROR_MESSAGE;

    private String ERROR_DETAILS;

    private String SEVERITY;

    private Date CREATED_DATETIME;

    private String EMPLOYEE_NAME;
}
