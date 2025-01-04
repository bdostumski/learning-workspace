package com.telerikacademy.wim.models.items;

import static com.telerikacademy.wim.models.common.Constants.DESCRIPTION_MAX_LENGTH;

import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.common.enums.StoryStatusType;
import com.telerikacademy.wim.models.items.contracts.CommonDetails;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import static com.telerikacademy.wim.models.common.Constants.*;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.items.contracts.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StoryImpl_Test {

    private static StoryImpl story = new StoryImpl("title-title-title",
            "description",
            PriorityType.HIGH,
            SizeType.LARGE);


    @Test
    public void StoryImpl_ShouldImplementStoryInterface() {
        //Assert
        Assertions.assertTrue(story instanceof Story);
    }

    @Test
    public void StoryImpl_ShouldImplementCommonDetailsInterface() {
        //Assert
        Assertions.assertTrue(story instanceof CommonDetails);
    }

    @Test
    public void StoryImpl_ShouldImplementWorkingItemInterface() {
        //Assert
        Assertions.assertTrue(story instanceof WorkingItems);
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsNull() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StoryImpl(null,
                        "description",
                        PriorityType.HIGH,
                        SizeType.LARGE));
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsBelow10() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StoryImpl(new String(new char[TITLE_MIN_LENGTH-1]),
                        "description",
                        PriorityType.HIGH,
                        SizeType.LARGE));
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsAbove50() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StoryImpl(new String(new char[TITLE_MAX_LENGTH+1]),
                        "description",
                        PriorityType.HIGH,
                        SizeType.LARGE));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsNull() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StoryImpl("title-title-title",
                        null,
                        PriorityType.HIGH,
                        SizeType.LARGE));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsBelow10() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StoryImpl("title-title-title",
                        new String(new char[DESCRIPTION_MIN_LENGTH-1]),
                        PriorityType.HIGH,
                        SizeType.LARGE));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsAbove50() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new StoryImpl("title-title-title",
                        new String(new char[DESCRIPTION_MAX_LENGTH+1]),
                        PriorityType.HIGH,
                        SizeType.LARGE));
    }

    @Test
    public void Method_getStorySizeType_ShouldThrow_WhenSizeTypeIsNotDefault() {
        Assertions.assertEquals(SizeType.LARGE, story.getStorySizeType());
    }

    @Test
    public void Method_changeStorySizeType_ShouldThrow_WhenSizeTypeIsNotChangedFromDefault() {
        StoryImpl story1 = new StoryImpl("title-title-title",
                "description",
                PriorityType.HIGH,
                SizeType.LARGE);

        story1.changeStorySizeType(SizeType.SMALL);
        Assertions.assertEquals(SizeType.SMALL, story1.getStorySizeType());
    }

    @Test
    public void Method_getStoryStatusType_ShouldThrow_WhenStatusTypeIsNotDefault() {
        Assertions.assertEquals(StoryStatusType.NOTDONE, story.getStoryStatusType());
    }

    @Test
    public void Method_changeStoryStatusType_ShouldThrow_WhenStatusTypeIsNotChanged() {
        StoryImpl story1 = new StoryImpl("title-title-title",
                "description",
                PriorityType.HIGH,
                SizeType.LARGE);
        story1.changeStoryStatusType(StoryStatusType.DONE);
        Assertions.assertEquals(StoryStatusType.DONE, story1.getStoryStatusType());
    }

    @Test
    public void Method_addAssignee_ShouldAddAssignee() {
        MemberImpl assignee = new MemberImpl("Assignee");
        story.changeAssignee(assignee);
        Assertions.assertEquals("Assignee", story.getAssignee().getName());
    }


}
