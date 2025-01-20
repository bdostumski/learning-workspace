package com.telerikacademy.wim.models.items.contracts;

import com.telerikacademy.wim.models.common.enums.FeedBackStatusType;

import java.io.Serializable;

public interface FeedBack extends WorkingItems, Serializable {

    int getRating();

    FeedBackStatusType getFeedBackStatusType();

    void changeFeedBackStatusType(FeedBackStatusType feedBackStatusType);

    void changeFeedBackRating(int rating);

}
