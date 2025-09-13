package com.zirius.zerp.model.erp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "firma", schema = "erp")
@Data
public class FirmaObject {

    public static final String PROPERTYNAME_firmaid = "firmaid";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_navn = "navn";
    public static final String PROPERTYNAME_orgnr = "orgnr";



    private int firmaid;
    @Id
    private int company_id;
    private String navn;
    private String orgnr;

    public int getFirmaid() {
        return firmaid;
    }

    public void setFirmaid(int firmaid) {
        this.firmaid = firmaid;
    }

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getOrgnr() {
        return orgnr;
    }

    public void setOrgnr(String orgnr) {
        this.orgnr = orgnr;
    }

}
