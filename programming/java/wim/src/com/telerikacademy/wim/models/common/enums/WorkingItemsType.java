package com.telerikacademy.wim.models.common.enums;

public enum WorkingItemsType {

    BUG,
    STORY,
    FEEDBACK;

    @Override
    public String toString() {
        switch(this) {
            case BUG:
                return "Bug";
            case STORY:
                return "Story";
            case FEEDBACK:
                return "FeedBack";
            default:
                throw new IllegalArgumentException("Unsupported working item!");
        }
    }

}
