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
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowAllWorkingItems_Test {

    @Test
    public void show_all_members_should_show_members_list(){

        WorkItemsController itemsController = new WorkItemsControllerImpl();
        List<String> params = new ArrayList<>();
        WorkingItems testItem = new BugImpl("Bug-For-Test", "Test-Bug-For-Testing", PriorityType.HIGH, SeverityType.MAJOR);

        itemsController.addNewWorkItem(testItem);
        ShowAllWorkingItems showItems = new ShowAllWorkingItems(itemsController);

        Assertions.assertNotNull(showItems.execute(params));

    }

    @Test
    public void show_all_members_should_show_error_message_when_no_members_found(){

        WorkItemsController itemsController = new WorkItemsControllerImpl();
        List<String> params = new ArrayList<>();

        ShowAllWorkingItems showItems = new ShowAllWorkingItems(itemsController);

        Assertions.assertEquals("There are no registered Items to work on yet.", showItems.execute(params));

    }
}
