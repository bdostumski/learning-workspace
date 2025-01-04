package com.telerikacademy.wim.models.common.enums;

public enum SeverityType {

    CRITICAL,
    MAJOR,
    MINOR;

    public static final String UNSUPPORTED_SEVERITY_TYPE = "Unsupported severity type!";

    @Override
    public String toString() {
        switch(this) {
            case CRITICAL:
                return "Critical";
            case MAJOR:
                return "Major";
            case MINOR:
                return "Minor";
            default:
                throw new IllegalArgumentException(UNSUPPORTED_SEVERITY_TYPE);
        }
    }

}
