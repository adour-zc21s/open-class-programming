package com.adour.openclassprog.enums;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 12/07/2026 - 15:52
 */
public enum Department {
    Accounting("Accounting"),
    Admin("Administration"),
    Aftersales("Aftersales"),
    CCO("CCO"),
    Finance("Finance"),
    GA("GA"),
    HRD("HRD"),
    Importation("Importation"),
    IT("IT"),
    Others("Other ..."),
    Recruitment("Recruitment"),
    Sales("Sales"),
    Tax("Tax");
    private final String DisplayDepartment;

    Department(String displayDepartment) {
        DisplayDepartment = displayDepartment;
    }
}
