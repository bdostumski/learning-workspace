package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SortBugsBySeverity_Test {

    private WorkingItems testBug, testBugTwo, testBugThree;
    private WorkItemsController itemsController;
    private SortBugsBySeverity sortBugsBySeverity;

    @BeforeEach
    public void before() {
        testBug = new BugImpl("Bug-For-Test", "Test-Bug-For-Testing", PriorityType.HIGH, SeverityType.MAJOR);
        testBugTwo = new BugImpl("ABug-For-Test", "Test-Bug-For-Testing", PriorityType.LOW, SeverityType.MINOR);
        testBugThree = new BugImpl("CBug-For-Test", "Test-Bug-For-Testing", PriorityType.MEDIUM, SeverityType.MAJOR);
        itemsController = new WorkItemsControllerImpl();
        sortBugsBySeverity = new SortBugsBySeverity(itemsController);

    }

    @Test
    public void sort_should_sort_bugs_by_severity() {
        List<String> params = new ArrayList<>();
        params.add("high");
        itemsController.addNewWorkItem(testBug);
        itemsController.addNewWorkItem(testBugTwo);
        itemsController.addNewWorkItem(testBugThree);

        Assertions.assertNotEquals("There are no registered bugs yet.", sortBugsBySeverity.execute(params));
    }

    @Test
    public void sort_should_show_message_when_no_bugs() {
        List<String> params = new ArrayList<>();

        Assertions.assertEquals("There are no registered bugs yet.", sortBugsBySeverity.execute(params));
    }

}
