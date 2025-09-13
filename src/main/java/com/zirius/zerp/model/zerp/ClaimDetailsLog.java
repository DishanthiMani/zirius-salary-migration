package com.zirius.zerp.model.zerp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
// @Entity
// @Table(name = "claim_details_log")
public class ClaimDetailsLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CLAIM_DETAILS_LOG_ID;

    private Integer SALARY_RUN_LOG_ID;

    private String ACCOUNT_NO;

    private String UNION_NAME;

    private String AMOUNT;

    private Integer CLAIM_COLLECTORS_ID;
}
