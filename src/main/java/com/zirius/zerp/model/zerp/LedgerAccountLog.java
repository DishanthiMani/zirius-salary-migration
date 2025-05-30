package com.zirius.zerp.model.zerp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "ledger_account_log")
public class LedgerAccountLog {

    @Id
    private Integer SALARY_RUN_LOG_ID;

    private BigDecimal TOTAL_SALARY;

    private BigDecimal TOTAL_TAX;

    private BigDecimal TOTAL_AMOUNT;
}
