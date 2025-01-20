package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.items.contracts.CommonDetails;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommonDetailsImpl_Test {

    @Test
    public void BugImpl_ShouldImplementCommonDetailsInterface() {
        CommonDetailsImpl commonDetails = new BugImpl("title-title-title", "description",
                PriorityType.HIGH, SeverityType.MAJOR);
        //Assert
        Assertions.assertTrue(commonDetails instanceof CommonDetails);
    }

    @Test
    public void StoryImpl_ShouldImplementCommonDetailsInterface() {
        CommonDetailsImpl commonDetails = new StoryImpl("title-title-title", "description",
                PriorityType.HIGH, SizeType.SMALL);
        //Assert
        Assertions.assertTrue(commonDetails instanceof CommonDetails);
    }
}
