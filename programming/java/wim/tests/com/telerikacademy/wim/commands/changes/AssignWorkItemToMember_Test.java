package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
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

public class AssignWorkItemToMember_Test {

    MembersController membersController;
    WorkItemsController itemsController;
    Command command;

    Member member;
    WorkingItems workingItem;

    @BeforeEach
    public void beforeEach() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);


        member = new MemberImpl("MemberName");
        workingItem = new BugImpl("Title-title-title", "Description", PriorityType.HIGH, SeverityType.MAJOR);

        List<Member> members = new ArrayList<>();
        members.add(member);

        List<WorkingItems> workingItems = new ArrayList<>();
        workingItems.add(workingItem);

        itemsController.updateItemsData(workingItems);
        membersController.updateMembersData(members);

        command = new AssignWorkItemToMember(membersController);

    }

    @Test
    public void AssignWorkItemToMember_Should_AssignWorkItemToMember_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(member.getName());
        list.add(String.format("%d", workingItem.getId()));

        //Act
        command.execute(list);

        // Assert
        Assertions.assertEquals(1, member.getWorkItems().size());
    }

    @Test
    public void AssignWorkItemToMember_ShouldThrow_Exception_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void AssignWorkItemToMember_ShouldThrow_Exception_When_PassedMoreArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");
        list.add("Argument3");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }
}
