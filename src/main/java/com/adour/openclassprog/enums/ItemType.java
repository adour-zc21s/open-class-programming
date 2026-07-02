package com.adour.openclassprog.enums;

/*
 * @author {Open Class Programming}
 * Abdur Rahman Wahid - X-Sari
 * +62 813 8522 9903
 * Created 02/07/2026 - 20:49
 */
public enum ItemType {
    L("Labour"),
    H("Hardware");
    private final String displayItemType;

    ItemType(String displayItemType) {
        this.displayItemType = displayItemType;
    }
    public String getDisplayItemType(){
        return displayItemType;
    }
}
