package com.telerikacademy.wim.models.common.enums;

public enum BugStatusType {

    ACTIVE,
    FIXED;

    public static final String UNSUPPORTED_BUG_STATUS_TYPE = "Unsupported bug status type!";

    @Override
    public String toString() {
        switch(this) {
            case ACTIVE:
                return "Active";
            case FIXED:
                return "Fixed";
            default:
                throw new IllegalArgumentException(UNSUPPORTED_BUG_STATUS_TYPE);
        }
    }

}
