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
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateBugInquiryInBoard_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;
    private WimFactory factory;

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

        List<Team> teams = new ArrayList<>();
        teams.add(team);

        teamsController.updateTeamsData(teams);

        team.addBoardToTeam(board);


        command = new CreateBugInquiryInBoard(teamsController, itemsController, factory);
    }

    @Test
    public void CreateBugInquiryInBoard_Should_CreateBug_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(team.getName());
        list.add(board.getName());
        list.add("Title-title-title");
        list.add("Bug Description");
        list.add(PriorityType.HIGH.toString());
        list.add(SeverityType.MAJOR.toString());


        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(1, board.getWorkItems().size());
    }

    @Test
    public void CreateBugInquiryInBoard_Should_Throw_Exception_When_PassedLessArguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void CreateBugInquiryInBoard_Should_Throw_Exception_When_PassedMoreArguments() {
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");
        list.add("Argument3");
        list.add("Argument4");

        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }
}
