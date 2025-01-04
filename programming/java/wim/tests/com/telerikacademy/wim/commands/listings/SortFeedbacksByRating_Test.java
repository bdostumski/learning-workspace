package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.items.FeedBackImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortFeedbacksByRating_Test {


    private WorkingItems testFeedback, testFeedbackTwo, testFeedbackThree;
    private WorkItemsController itemsController;
    private SortfeedbacksByRating sortbyRating;

    @BeforeEach
    public void before() {
       testFeedback = new FeedBackImpl("ATest-Feedback", "feedback-for-testing-purpose", 5);
        testFeedbackTwo = new FeedBackImpl("CTest-Feedback", "feedback-for-testing-purpose", 3);
        testFeedbackThree = new FeedBackImpl("BTest-Feedback", "feedback-for-testing-purpose", 4);
        itemsController = new WorkItemsControllerImpl();
        sortbyRating = new SortfeedbacksByRating(itemsController);

    }

    @Test
    public void sort_should_sort_by_rating() {
        List<String> params = new ArrayList<>();
        itemsController.addNewWorkItem(testFeedbackTwo);
        itemsController.addNewWorkItem(testFeedback);
        itemsController.addNewWorkItem(testFeedbackThree);

        Assertions.assertNotEquals("There are no registered feedbacks yet.", sortbyRating.execute(params));
    }

    @Test
    public void sort_should_show_message_when_no_items() {
        List<String> params = new ArrayList<>();

        Assertions.assertEquals("There are no registered feedbacks yet.", sortbyRating.execute(params));
    }

}
