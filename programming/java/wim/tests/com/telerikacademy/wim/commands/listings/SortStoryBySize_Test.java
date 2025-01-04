package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.items.StoryImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortStoryBySize_Test {

    private WorkingItems testStory, testStoryTwo, testStoryThree;
    private WorkItemsController itemsController;
    private SortStoryBySize sortBySize;

    @BeforeEach
    public void before() {
        testStory = new StoryImpl("Story-for_test", "Test-Story-For-Testing", PriorityType.HIGH, SizeType.MEDIUM);
        testStoryTwo = new StoryImpl("BStory-for_test", "Test-Story-For-Testing", PriorityType.HIGH, SizeType.LARGE);
        testStoryThree = new StoryImpl("CStory-for_test", "Test-Story-For-Testing", PriorityType.HIGH, SizeType.SMALL);
        itemsController = new WorkItemsControllerImpl();
        sortBySize = new SortStoryBySize(itemsController);

    }

    @Test
    public void show_bugs_should_show_sorted_stories() {
        List<String> params = new ArrayList<>();

        itemsController.addNewWorkItem(testStoryTwo);
        itemsController.addNewWorkItem(testStoryThree);
        itemsController.addNewWorkItem(testStory);

        Assertions.assertNotEquals("There are no registered stories yet.", sortBySize.execute(params));
    }

    @Test
    public void show_bugs_should_show_message_when_no_stories() {
        List<String> params = new ArrayList<>();

        Assertions.assertEquals("There are no registered stories yet.",sortBySize.execute(params));
    }
}
