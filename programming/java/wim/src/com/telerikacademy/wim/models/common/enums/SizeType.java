package com.telerikacademy.wim.models.common.enums;

public enum SizeType {

    LARGE,
    MEDIUM,
    SMALL;

    public static final String UNSUPPORTED_SIZE_TYPE = "Unsupported size type!";

    @Override
    public String toString() {
        switch(this) {
            case LARGE:
                return "Large";
            case MEDIUM:
                return "Medium";
            case SMALL:
                return "Small";
            default:
                throw new IllegalArgumentException(UNSUPPORTED_SIZE_TYPE);
        }
    }

}
