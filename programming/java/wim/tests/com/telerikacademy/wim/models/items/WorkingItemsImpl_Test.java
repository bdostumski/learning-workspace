package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkingItemsImpl_Test {


    @Test
    public void BugImpl_ShouldImplementWorkingItemsInterface() {
        WorkingItemsImpl workingItems = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MINOR);
        //Assert
        Assertions.assertTrue(workingItems instanceof WorkingItems);
    }

    @Test
    public void FeedBackImpl_ShouldImplementWorkingItemsInterface() {
        WorkingItemsImpl workingItems = new FeedBackImpl("title-title-title", "description", 1);
        //Assert
        Assertions.assertTrue(workingItems instanceof WorkingItems);
    }

    @Test
    public void StoryImpl_ShouldImplementWorkingItemsInterface() {
        WorkingItemsImpl workingItems = new StoryImpl("title-title-title", "description", PriorityType.HIGH, SizeType.SMALL);
        //Assert
        Assertions.assertTrue(workingItems instanceof WorkingItems);
    }

}
