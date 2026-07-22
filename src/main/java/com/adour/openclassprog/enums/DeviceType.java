package com.adour.openclassprog.enums;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 23/06/2026 - 18:34
 */
public enum DeviceType {
    AP("Access Point"),
    Desktop("PC/All in one"),
    Gadget("Gadget"),
    Laptop("Laptop"),
    Mikrotik("Mikrotik"),
    Peripherals("Peripheral"),
    Printer("Printer"),
    Router("Router"),
    Server("Server"),
    Switch("Switch"),
    Telephone("Telephone");
    private final String displayType;
    DeviceType(String displayType) {
        this.displayType = displayType;
    }
    public String getDisplayType() {
        return displayType;
    }
}
