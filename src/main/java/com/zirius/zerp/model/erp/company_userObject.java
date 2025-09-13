package com.zirius.zerp.model.erp;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "company_user", schema = "erp")
@Data
public class company_userObject {

    public static final String PROPERTYNAME_sid = "sid";
    public static final String PROPERTYNAME_selgerid = "selgerid";
    public static final String PROPERTYNAME_company_id = "company_id";
    public static final String PROPERTYNAME_user_id = "user_id";
    public static final String PROPERTYNAME_is_confirmed_user = "is_confirmed_user";
    public static final String PROPERTYNAME_navn = "navn";
    public static final String PROPERTYNAME_lagerid = "lagerid";
    public static final String PROPERTYNAME_passord = "passord";
    public static final String PROPERTYNAME_brukernavn = "brukernavn";
    public static final String PROPERTYNAME_adresse1 = "adresse1";
    public static final String PROPERTYNAME_adresse2 = "adresse2";
    public static final String PROPERTYNAME_adresse3 = "adresse3";
    public static final String PROPERTYNAME_state = "state";
    public static final String PROPERTYNAME_postnrid = "postnrid";
    public static final String PROPERTYNAME_poststed = "poststed";
    public static final String PROPERTYNAME_endretdato = "endretdato";
    public static final String PROPERTYNAME_endretav = "endretav";
    public static final String PROPERTYNAME_opprettetdato = "opprettetdato";
    public static final String PROPERTYNAME_opprettetav = "opprettetav";
    public static final String PROPERTYNAME_telefon = "telefon";
    public static final String PROPERTYNAME_mobil = "mobil";
    public static final String PROPERTYNAME_telefax = "telefax";
    public static final String PROPERTYNAME_email = "email";
    public static final String PROPERTYNAME_merknader = "merknader";
    public static final String PROPERTYNAME_selger = "selger";
    public static final String PROPERTYNAME_systembruker = "systembruker";
    public static final String PROPERTYNAME_avdelingid = "avdelingid";
    public static final String PROPERTYNAME_innkjoper = "innkjoper";
    public static final String PROPERTYNAME_ansatt = "ansatt";
    public static final String PROPERTYNAME_synkes = "synkes";
    public static final String PROPERTYNAME_synket = "synket";
    public static final String PROPERTYNAME_pdasynk = "pdasynk";
    public static final String PROPERTYNAME_pdaadmin = "pdaadmin";
    public static final String PROPERTYNAME_pdabruker = "pdabruker";
    public static final String PROPERTYNAME_pdalagerstyring = "pdalagerstyring";
    public static final String PROPERTYNAME_stillingid = "stillingid";
    public static final String PROPERTYNAME_pdalagerendring = "pdalagerendring";
    public static final String PROPERTYNAME_ordreinkmva = "ordreinkmva";
    public static final String PROPERTYNAME_stilling = "stilling";
    public static final String PROPERTYNAME_antdagbokforinger = "antdagbokforinger";
    public static final String PROPERTYNAME_smtpserver = "smtpserver";
    public static final String PROPERTYNAME_varekatalogid = "varekatalogid";
    public static final String PROPERTYNAME_prosjektid = "prosjektid";
    public static final String PROPERTYNAME_dimensjon1id = "dimensjon1id";
    public static final String PROPERTYNAME_dimensjon2id = "dimensjon2id";
    public static final String PROPERTYNAME_altinnuse = "altinnuse";
    public static final String PROPERTYNAME_altinnfinalize = "altinnfinalize";
    public static final String PROPERTYNAME_altinnsystemid = "altinnsystemid";
    public static final String PROPERTYNAME_altinnsystempass = "altinnsystempass";
    public static final String PROPERTYNAME_gyldigfra = "gyldigfra";
    public static final String PROPERTYNAME_gyldigtil = "gyldigtil";
    public static final String PROPERTYNAME_kasseprofil = "kasseprofil";
    public static final String PROPERTYNAME_kassebruker = "kassebruker";
    public static final String PROPERTYNAME_kassesperret = "kassesperret";
    public static final String PROPERTYNAME_resetkassepassord = "resetkassepassord";
    public static final String PROPERTYNAME_attestasjon = "attestasjon";
    public static final String PROPERTYNAME_online_approval = "online_approval";
    public static final String PROPERTYNAME_zirius_approval = "zirius_approval";
    public static final String PROPERTYNAME_androidtimelistebruker = "androidtimelistebruker";
    public static final String PROPERTYNAME_zainnkjop = "zainnkjop";
    public static final String PROPERTYNAME_zalagerplukk = "zalagerplukk";
    public static final String PROPERTYNAME_zaprosjekt = "zaprosjekt";
    public static final String PROPERTYNAME_zapinkode = "zapinkode";
    public static final String PROPERTYNAME_innleid = "innleid";
    public static final String PROPERTYNAME_zirius_web_bruker = "zirius_web_bruker";
    public static final String PROPERTYNAME_zirius_web_invitation = "zirius_web_invitation";
    public static final String PROPERTYNAME_invitation_lang = "invitation_lang";
    public static final String PROPERTYNAME_zirius_web_brukerid = "zirius_web_brukerid";
    public static final String PROPERTYNAME_version_upgrade = "version_upgrade";
    public static final String PROPERTYNAME_ansattnr = "ansattnr";
    public static final String PROPERTYNAME_landid = "landid";
    public static final String PROPERTYNAME_inactive = "inactive";
    public static final String PROPERTYNAME_last_login_to_company = "last_login_to_company";
    public static final String PROPERTYNAME_api_user = "api_user";
    public static final String PROPERTYNAME_sales_person = "sales_person";
    public static final String PROPERTYNAME_employee = "employee";
    public static final String PROPERTYNAME_birth_date = "birth_date";

    @Id
    private String sid;

    private String selgerid;
    private int company_id = 0;


    private String user_id = "";
    private boolean is_confirmed_user;

    private String navn;
    private int lagerid;

    private String passord;

    private String brukernavn;

    private String adresse1;

    private String adresse2;

    private String adresse3;

    private String state;

    private String postnrid;

    private String poststed;
    private LocalDateTime endretdato;

    private String endretav;
    private LocalDateTime opprettetdato;

    private String opprettetav;

    private String telefon;

    private String mobil;

    private String telefax;

    private String email;

    private String merknader;
    private boolean selger;
    private boolean systembruker;

    private String avdelingid;
    private boolean innkjoper;
    private boolean ansatt;
    private boolean synkes;
    private boolean synket;
    private boolean pdasynk;
    private boolean pdaadmin;
    private boolean pdabruker;
    private boolean pdalagerstyring;
    private int stillingid;
    private boolean pdalagerendring;
    private boolean ordreinkmva;
    private int stilling;
    private int antdagbokforinger = 0;


    private String smtpserver = "";
    private int varekatalogid;

    private String prosjektid;

    private String dimensjon1id;

    private String dimensjon2id;
    private boolean altinnuse;
    private boolean altinnfinalize;
    private int altinnsystemid = 0;

    private String altinnsystempass;
    private LocalDate gyldigfra = null;
    private LocalDate gyldigtil = null;


    private String kasseprofil = "1";
    private int kassebruker;
    private boolean kassesperret;
    private boolean resetkassepassord;
    private boolean attestasjon;
    private boolean online_approval;
    private boolean zirius_approval;
    private boolean androidtimelistebruker;
    private boolean zainnkjop;
    private boolean zalagerplukk;
    private boolean zaprosjekt;

    private String zapinkode;
    private boolean innleid;
    private boolean zirius_web_bruker;
    private boolean zirius_web_invitation;

    private String invitation_lang;

    private String zirius_web_brukerid;
    private boolean version_upgrade;

    private String ansattnr;

    private String landid;
    private boolean inactive;
    private LocalDateTime last_login_to_company;
    private boolean api_user;
    private boolean sales_person;
    private boolean employee;
    private LocalDate birth_date = null;
}

