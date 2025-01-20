package com.telerikacademy.wim.models.items;

import static com.telerikacademy.wim.models.common.Constants.*;
import static com.telerikacademy.wim.models.common.Validator.validateIntRange;

import com.telerikacademy.wim.models.common.enums.FeedBackStatusType;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.FeedBack;

import java.io.Serializable;

public class FeedBackImpl extends WorkingItemsImpl implements FeedBack, Serializable {

    private int rating;
    private FeedBackStatusType feedBackStatusType;

    public FeedBackImpl(String title, String description, int rating) {
        super(title, description, WorkingItemsType.FEEDBACK);
        setRating(rating);
        this.feedBackStatusType = FeedBackStatusType.NEW;
    }

    @Override
    public int getRating() {
        return rating;
    }

    @Override
    public FeedBackStatusType getFeedBackStatusType() {
        return feedBackStatusType;
    }

    @Override
    public void changeFeedBackStatusType(FeedBackStatusType feedBackStatusType) {
        this.feedBackStatusType = feedBackStatusType;
    }

    @Override
    public String getStatusString() {
        return feedBackStatusType.toString();
    }

    @Override
    public void changeFeedBackRating(int rating) {
        setRating(rating);
    }

    private void setRating(int rating) {
        validateIntRange(rating, RATING_RANGE_MIN, RATING_RANGE_MAX, RATING_RANGE_ERROR);
        this.rating = rating;
    }

    public String toString() {
        return String.format("%s" +
                "Rating: %s%n" +
                "Status: %s%n", super.toString(), rating, feedBackStatusType);
    }

}
