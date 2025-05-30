package com.zirius.zerp.model.erp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "firma")
@Data
public class FirmaObject {
    @Id
    private Integer FIRMAID;
    private Integer COMPANY_ID;
    private String NAVN;
    private String ORGNR;
}
