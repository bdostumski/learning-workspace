package com.telerikacademy.wim.commands.creation;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.core.factories.WimFactoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateMemberCommand_Test {


    private MembersController membersController;
    private WorkItemsController itemsController;
    private WimFactory factory;
    private Command command;

    @BeforeEach
    public void before() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        factory = new WimFactoryImpl();
        command = new CreateMemberCommand(membersController, factory);
    }

    @Test
    public void CreateMemberCommand_Should_CreateMember_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("MemberName");

        //Assert & Act
        Assertions.assertDoesNotThrow(() -> command.execute(list));
    }

    @Test
    public void CreateMemberCommand_Should_Throw_Exception_When_PassedLessArguments() {
        List<String> list = new ArrayList<>();
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void CreateMemberCommand_Should_Throw_Exception_When_PassedMoreArguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

}
