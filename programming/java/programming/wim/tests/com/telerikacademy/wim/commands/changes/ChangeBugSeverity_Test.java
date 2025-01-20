package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
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

public class ChangeBugSeverity_Test {

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

        command = new ChangeBugSeverity(controller);
    }

    @Test
    public void ChangeBugSeverity_CheckSeverityType() {
        //Act & Assert
        Assertions.assertEquals(SeverityType.MAJOR, bug.getSeverityType());
    }

    @Test
    public void ChangeBugSeverity_CheckChangedSeverity() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(String.format("%d", bug.getId()));
        list.add(SeverityType.CRITICAL.toString());

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(SeverityType.CRITICAL, bug.getSeverityType());
    }

}
