package com.telerikacademy.wim.models.common.enums;

public enum FeedBackStatusType {

    NEW,
    UNSCHEDULED,
    SCHEDULED,
    DONE;

    public static final String UNSUPPORTED_FEEDBACK_STATUS_TYPE = "Unsupported feed back status type!";

    @Override
    public String toString() {
        switch(this) {
            case NEW:
                return "New";
            case UNSCHEDULED:
                return "Unscheduled";
            case SCHEDULED:
                return "Scheduled";
            case DONE:
                return "Done";

            default:
                throw new IllegalArgumentException(UNSUPPORTED_FEEDBACK_STATUS_TYPE);
        }
    }
}
