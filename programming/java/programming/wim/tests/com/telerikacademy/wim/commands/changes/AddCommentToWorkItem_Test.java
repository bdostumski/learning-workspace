package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.contracts.Comment;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.*;
import java.util.ArrayList;
import java.util.List;

public class AddCommentToWorkItem_Test {

    private WorkItemsController controller;
    private Command command;

    private WorkingItems workingItems;

    @BeforeEach
    public void before() {

        workingItems = new BugImpl("Title-title-title", "Description", PriorityType.HIGH, SeverityType.MAJOR);

        controller =new WorkItemsControllerImpl();
        controller.addNewWorkItem(workingItems);
        command = new AddCommentToWorkItem(controller);
    }

    @Test
    public void AddCommentToWorkItem_Should_AddComment_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(String.format("%d", workingItems.getId()));
        list.add("Message");
        list.add("Author");

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(1, workingItems.getComments().size());
    }

    @Test
    public void AddCommentToWorkItem_Should_Throw_Exception_When_PassedLessArguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void AddCommentToWorkItem_Should_Throw_Exception_When_PassedMoreAreguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");
        list.add("Argument3");
        list.add("Argument4");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

}
