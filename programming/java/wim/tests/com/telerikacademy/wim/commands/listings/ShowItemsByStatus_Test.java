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

public class ShowItemsByStatus_Test {

    private WorkingItems testBug;
    private WorkingItems testStory;
    private WorkingItems testFeedback;
    WorkItemsController itemsController;
    private ShowItemsByStatus showItemsByStatus;

    @BeforeEach
    public void before() {
        testBug = new BugImpl("Bug-For-Test", "Test-Bug-For-Testing", PriorityType.HIGH, SeverityType.MAJOR);
        testStory = new StoryImpl("Story-for_test", "Test-Story-For-Testing", PriorityType.HIGH, SizeType.MEDIUM);
        testFeedback = new FeedBackImpl("test-Feedback", "feedback-for-testing-purpose", 5);
        itemsController = new WorkItemsControllerImpl();
        showItemsByStatus = new ShowItemsByStatus(itemsController);

    }

    @Test
    public void show_items_by_status_should_arrange_bugs_by_status_when_valid_params() {
        List<String> params = new ArrayList<>();
        params.add("active");
        itemsController.addNewWorkItem(testStory);
        itemsController.addNewWorkItem(testFeedback);
        itemsController.addNewWorkItem(testBug);

        Assertions.assertNotEquals("There are no registered items with such status yet.", showItemsByStatus.execute(params));
    }

    @Test
    public void show_items_by_status_should_arrange_feedbacks_by_status_when_valid_params() {
        List<String> params = new ArrayList<>();
        params.add("new");
        itemsController.addNewWorkItem(testStory);
        itemsController.addNewWorkItem(testFeedback);
        itemsController.addNewWorkItem(testBug);

        Assertions.assertNotEquals("There are no registered items with such status yet.", showItemsByStatus.execute(params));
    }

    @Test
    public void show_items_by_status_should_arrange_stories_by_status_when_valid_params() {
        List<String> params = new ArrayList<>();
        params.add("notdone");
        itemsController.addNewWorkItem(testStory);
        itemsController.addNewWorkItem(testFeedback);
        itemsController.addNewWorkItem(testBug);

        Assertions.assertNotEquals("There are no registered items with such status yet.", showItemsByStatus.execute(params));
    }

    @Test
    public void show_items_by_status_should_throw_when_invalid_params() {
        List<String> params = new ArrayList<>();
        params.add("lorem ipsum");
        itemsController.addNewWorkItem(testStory);
        itemsController.addNewWorkItem(testFeedback);
        itemsController.addNewWorkItem(testBug);

        Assertions.assertEquals("There are no registered items with such status yet.", showItemsByStatus.execute(params));
    }

}
