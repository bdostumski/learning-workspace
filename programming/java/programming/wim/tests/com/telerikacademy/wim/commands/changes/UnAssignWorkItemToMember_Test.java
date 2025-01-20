package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class UnAssignWorkItemToMember_Test {


    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;

    Member member;
    WorkingItems workingItem;

    @BeforeEach
    public void beforeEach() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);


        member = new MemberImpl("MemberName");
        workingItem = new BugImpl("Title-title-title", "Description", PriorityType.HIGH, SeverityType.MAJOR);

        membersController.addNewMember(member);
        itemsController.addNewWorkItem(workingItem);

        member.addWorkItem(workingItem);

        command = new UnAssignWorkItemToMember(membersController);

    }

    @Test
    public void UnAssignWorkItemToTeam__Should_UnAssignWorkItemToTeam_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(member.getName());
        list.add(String.valueOf(workingItem.getId()));

        //Act
        command.execute(list);

        // Assert
        Assertions.assertEquals(0, member.getWorkItems().size());
    }

    @Test
    public void UnAssignWorkItemToMember_ShouldThrow_Exception_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void UnAssignWorkItemToMember_ShouldThrow_Exception_When_PassedMoreArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(member.getName());
        list.add(String.valueOf(workingItem.getId()));
        list.add("MoreArguments");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

}
