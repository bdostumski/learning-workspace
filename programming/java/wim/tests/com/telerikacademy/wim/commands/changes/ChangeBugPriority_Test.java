package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
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

public class ChangeBugPriority_Test {

    WorkItemsController controller;
    Command command;


    Bug bug;

    @BeforeEach
    public void beforeEach() {

        controller = new WorkItemsControllerImpl();

        bug = new BugImpl("Title-title-title", "Description", PriorityType.HIGH, SeverityType.MAJOR);

        List<WorkingItems> bugs = new ArrayList<>();
        bugs.add(bug);

        controller.addNewWorkItem(bug);
        command = new ChangeBugPriority(controller);
    }

    @Test
    public void ChangeBugPriority_CheckPriority() {
        //Act & Assert
        Assertions.assertEquals(PriorityType.HIGH, bug.getPriority());
    }

    @Test
    public void ChangeBugPriority_CheckChangedPriority() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(String.format("%d", bug.getId()));
        list.add(PriorityType.LOW.toString());

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(PriorityType.LOW, bug.getPriority());
    }

}
