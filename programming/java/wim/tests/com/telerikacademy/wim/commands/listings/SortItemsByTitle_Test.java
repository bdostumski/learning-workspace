package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.FeedBackImpl;
import com.telerikacademy.wim.models.items.StoryImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortItemsByTitle_Test {

    private WorkingItems testBug, testBugTwo, testBugThree;
    private WorkingItems testStory;
    private WorkingItems testFeedback;
    private WorkItemsController itemsController;
    private SortItemsByTitle sortItemsByTitle;

    @BeforeEach
    public void before() {
        testBug = new BugImpl("Bug-For-Test", "Test-Bug-For-Testing", PriorityType.HIGH, SeverityType.MAJOR);
        testBugTwo = new BugImpl("ABug-For-Test", "Test-Bug-For-Testing", PriorityType.HIGH, SeverityType.MAJOR);
        testBugThree = new BugImpl("CBug-For-Test", "Test-Bug-For-Testing", PriorityType.HIGH, SeverityType.MAJOR);
        testStory = new StoryImpl("Story-for_test", "Test-Story-For-Testing", PriorityType.HIGH, SizeType.MEDIUM);
        testFeedback = new FeedBackImpl("ATest-Feedback", "feedback-for-testing-purpose", 5);
        itemsController = new WorkItemsControllerImpl();
        sortItemsByTitle = new SortItemsByTitle(itemsController);

    }

    @Test
    public void sort_should_sort_by_name() {
        List<String> params = new ArrayList<>();

         itemsController.addNewWorkItem(testBug);
         itemsController.addNewWorkItem(testFeedback);
         itemsController.addNewWorkItem(testStory);
         itemsController.addNewWorkItem(testBugTwo);
         itemsController.addNewWorkItem(testBugThree);

        Assertions.assertNotEquals("There are no registered working items yet.", sortItemsByTitle.execute(params));
    }

    @Test
    public void sort_should_show_message_when_no_items() {
        List<String> params = new ArrayList<>();

        Assertions.assertEquals("There are no registered working items yet.",sortItemsByTitle.execute(params));
    }

}
