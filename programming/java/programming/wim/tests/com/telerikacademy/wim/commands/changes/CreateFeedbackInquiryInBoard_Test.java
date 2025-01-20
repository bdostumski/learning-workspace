package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.TeamsControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.core.factories.WimFactoryImpl;
import com.telerikacademy.wim.models.BoardImpl;
import com.telerikacademy.wim.models.TeamImpl;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateFeedbackInquiryInBoard_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private WimFactory factory;
    private Command command;

    private Team team;
    private Board board;

    @BeforeEach
    public void before() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);
        factory = new WimFactoryImpl();

        team = new TeamImpl("TeamName");
        board = new BoardImpl("BoardName");

        teamsController.addNewTeam(team);

        team.addBoardToTeam(board);

        command = new CreateFeedbackInquiryInBoard(teamsController, itemsController, factory);


    }

    @Test
    public void CreateFeedBackInquiryInBoard_Should_CreateFeedBackInquiryInBoard_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(team.getName());
        list.add(board.getName());
        list.add("Title-title-title");
        list.add("FeedBack Description");
        list.add(String.valueOf(1));


        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(1, board.getWorkItems().size());
    }

    @Test
    public void CreateFeedBackInquiryInBoard_Should_Throw_Exception_When_PassedLessArguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void CreateFeedBackInquiryInBoard_Throw_Exception_When_PassedMoreArguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");
        list.add("Argument3");
        list.add("Argument4");
        list.add("Argument5");
        list.add("Argument6");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

}
