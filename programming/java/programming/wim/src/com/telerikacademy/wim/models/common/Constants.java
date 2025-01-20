package com.telerikacademy.wim.models.common;

public class Constants {

    // TITLE CONSTANTS
    public static final int TITLE_MIN_LENGTH = 10;
    public static final int TITLE_MAX_LENGTH = 50;
    public static final String TITLE_ERROR = String.format("Title length should be between %d and %d.",
            TITLE_MIN_LENGTH, TITLE_MAX_LENGTH);

    public static final int DESCRIPTION_MIN_LENGTH = 10;
    public static final int DESCRIPTION_MAX_LENGTH = 500;
    public static final String DESCRIPTION_ERROR = String.format("Description length should be between %d and %d",
            DESCRIPTION_MIN_LENGTH, DESCRIPTION_MAX_LENGTH);

    public static final String NULL_COMMENT_ERROR = "Comment to add can't be null!";
    public static final String NULL_TITLE_ERROR = "Title can't be null!";
    public static final String NULL_DESCRIPTION_ERROR = "Description can't be null!";

    // FEED BACK CONSTANTS
    public static final String RATING_LESS_THAN_ZERO_ERROR = "Rating can't be less than 0!";

    // COMMON DETAILS CONSTANTS
    public static final String NULL_ASSIGNEE_ERROR = "Assignee can't be null!";

    // COMMENT CONSTANTS
    public static final String NULL_MESSAGE_ERROR = "Message can't be null!";
    public static final String NULL_AUTHOR_ERROR = "Author can't be null!";
    public static final int RATING_RANGE_MAX = 5;
    public static final int RATING_RANGE_MIN = 0;
    public static final String RATING_RANGE_ERROR = String.format("Rating range should be between %d and %d",
            RATING_RANGE_MIN, RATING_RANGE_MAX);

    // BUG CONSTANTS
    public static final String NULL_STEPS_REPRODUCE_ERROR = "Steps to reproduce can't be null!";
    public static final String LIST_DOES_NOT_CONTAIN_STEPS_TO_REPRODUCE = "List does not contain steps to reproduce!";

}
