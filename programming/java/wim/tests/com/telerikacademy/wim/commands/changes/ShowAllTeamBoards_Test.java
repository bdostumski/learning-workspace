package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.TeamsControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.BoardImpl;
import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.TeamImpl;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowAllTeamBoards_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;

    private Team team;
    private Board board;
    private Board board1;
    private Member member;

    @BeforeEach
    public void before() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);

        member = new MemberImpl("MemberName");
        team = new TeamImpl("TeamName");
        board = new BoardImpl("BoardName");
        board1 = new BoardImpl("BoardName1");

        team.addMemberToTeam(member);
        team.addBoardToTeam(board);
        team.addBoardToTeam(board1);

        teamsController.addNewTeam(team);
        command = new ShowAllTeamBoards(teamsController);

    }

    @Test
    public void ShowAllTeamBoards_Should_ThrowException_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowAllTeamBoards_Should_ThrowException_When_PassMoreArgument() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowAllTeamBoards_Should_ShowAllTeamBord_When_PassExpectedArguments() {
        List<String> list = new ArrayList<>();
        list.add(team.getName());

        //Act
        command.execute(list);
//        System.out.println(controller.showTeamBoards(team.getName()));

        //Assert
        Assertions.assertEquals(2, team.getTeamBoards().size());
    }
}
