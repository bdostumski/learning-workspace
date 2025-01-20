package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.commands.listings.ShowBugsOnly;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.BugStatusType;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.contracts.Bug;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChangeBugStatus_Test {

    private WorkItemsController controller;
    private Command command;

    private Bug bug;

    @BeforeEach
    public void beforeEach() {

        controller = new WorkItemsControllerImpl();

        bug = new BugImpl("Title-title-title", "Description", PriorityType.HIGH, SeverityType.MAJOR);

        List<WorkingItems> bugs = new ArrayList<>();
        bugs.add(bug);

        controller.updateItemsData(bugs);
        command = new ChangeBugStatus(controller);

    }

    @Test
    public void ChangeBugStatus_CheckBugStatus() {
        //Act & Assert
        Assertions.assertEquals(BugStatusType.ACTIVE, bug.getBugStatusType());
    }

    @Test
    public void ChangeBugStatus_CheckChangedStatus() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(String.format("%d", bug.getId()));
        list.add(BugStatusType.FIXED.toString());

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(BugStatusType.FIXED, bug.getBugStatusType());
    }

}
