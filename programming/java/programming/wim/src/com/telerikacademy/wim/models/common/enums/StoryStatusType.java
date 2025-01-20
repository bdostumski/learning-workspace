package com.telerikacademy.wim.models.common.enums;

public enum StoryStatusType {

    NOTDONE,
    INPROGRESS,
    DONE;

    public static final String UNSUPPORTED_STORY_STATUS_TYPE = "Unsupported story status type!";

    @Override
    public String toString() {
        switch(this) {
            case NOTDONE:
                return "NotDone";
            case INPROGRESS:
                return "InProgress";
            case DONE:
                return "Done";

            default:
                throw new IllegalArgumentException(UNSUPPORTED_STORY_STATUS_TYPE);
        }
    }
}
