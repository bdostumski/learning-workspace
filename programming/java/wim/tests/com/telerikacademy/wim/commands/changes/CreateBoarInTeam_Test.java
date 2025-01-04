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
import com.telerikacademy.wim.models.TeamImpl;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CreateBoarInTeam_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;
    private WimFactory factory;

    private Team team;

    @BeforeEach
    public void before() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);
        factory = new WimFactoryImpl();

        team = new TeamImpl("TeamName");

        List<Team> teams = new ArrayList<>();
        teams.add(team);

        teamsController.updateTeamsData(teams);
        command = new CreateBoardInTeam(teamsController, factory);

    }

    @Test
    public void CreateBoarInTeam_Should_CreateBoard_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("BoardName");
        list.add(team.getName());

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(1, team.getTeamBoards().size());
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
