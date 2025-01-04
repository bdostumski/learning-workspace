package com.telerikacademy.wim.models.common.enums;

public enum PriorityType {

    HIGH,
    MEDIUM,
    LOW;

    public static final String UNSUPPORTED_PRIORITY_TYPE = "Unsupported priority type!";

    @Override
    public String toString() {
        switch(this) {
            case HIGH:
                return "High";
            case MEDIUM:
                return "Medium";
            case LOW:
                return "Low";
            default:
                throw new IllegalArgumentException(UNSUPPORTED_PRIORITY_TYPE);
        }
    }

}
