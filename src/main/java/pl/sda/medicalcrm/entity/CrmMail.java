package pl.sda.medicalcrm.entity;

public enum CrmMail {
    APIKEY("5b60e2f7e91d81b6954285a9a9aa4af8"),
    APISECRET("ac08fc57bcda3a8fec574d7d510e4883"),
    CRMADDRESS("medicalcrm23@gmail.com"),
    CRMNAME("MedicalCRM");

    public String value;

    CrmMail(String v) {
        value = v;
    }

    public String showValue() {
        return value;
    }
}

