package com.telerikacademy.wim.models.items;

import static com.telerikacademy.wim.models.common.Constants.DESCRIPTION_MAX_LENGTH;

import com.telerikacademy.wim.models.common.enums.FeedBackStatusType;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import static com.telerikacademy.wim.models.common.Constants.*;
import com.telerikacademy.wim.models.items.contracts.FeedBack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeedBackImpl_Test {

    private static FeedBackImpl feedBack = new FeedBackImpl("title-title-title", "description", 2);

    @Test
    public void FeedBackImpl_ShouldImplementFeedBackInterface() {
        //Assert
        Assertions.assertTrue(feedBack instanceof FeedBack);
    }

    @Test
    public void FeedBackImpl_ShouldImplementWorkingTimesInterface() {
        //Assert
        Assertions.assertTrue(feedBack instanceof WorkingItems);
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsNull() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl(null, "description", 1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsBelow10() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl(new String(new char[TITLE_MIN_LENGTH-1]), "description", 1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsAbove50() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl(new String(new char[TITLE_MAX_LENGTH+1]), "description",1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsNull() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl("title-title-title", null,1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsBelow10() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl("title-title-title", new String(new char[DESCRIPTION_MIN_LENGTH-1]),1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsAbove50() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl("title-title-title", new String(new char[DESCRIPTION_MAX_LENGTH+1]),1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenRatingIsLessThan0() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl("title-title-title", "description", -1));
    }

    @Test
    public void Constructor_ShouldThrow_WhenRatingIsAbove5() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new FeedBackImpl("title-title-title", "decription", 6));
    }

    @Test
    public void Method_ratingRange_CheckRatingRange() {
        Assertions.assertEquals(2, feedBack.getRating());
    }

    @Test
    public void check_feedBackStatusType() {
        FeedBackImpl feedBack = new FeedBackImpl("title-title-title", "description", 2);
        Assertions.assertEquals(FeedBackStatusType.NEW, feedBack.getFeedBackStatusType());
    }

    @Test
    public void check_feedBackChangeType() {
        feedBack.changeFeedBackStatusType(FeedBackStatusType.DONE);
        Assertions.assertEquals(FeedBackStatusType.DONE, feedBack.getFeedBackStatusType());
    }

}
