package com.adour.openclassprog.enums;

import lombok.Data;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 18:34
 */
public enum DeviceType {
    Desktop("PC/All in one"),
    Laptop("Laptop"),
    Printer("Printer"),
    Server("Server"),
    Switch("Switch"),
    Router("Router"),
    Mikrotik("Mikrotik");
    private final String displayType;

    DeviceType(String displayType) {
        this.displayType = displayType;
    }

    public String getDisplayType() {
        return displayType;
    }
}
