package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.TeamsControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
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

public class ShowTeamActivity_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;

    private Team team;
    private Board board;
    private Member member;

    @BeforeEach
    public void before() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);

        member = new MemberImpl("MemberName");
        team = new TeamImpl("TeamName");
        board = new BoardImpl("BoardName");

        membersController.addNewMember(member);
        teamsController.addNewTeam(team);

        team.addMemberToTeam(member);
        team.addBoardToTeam(board);
        team.removeMemberFromTeam(member);

        command = new ShowTeamActivity(teamsController);
    }

    @Test
    public void ShowTeamActivity_Should_ThrowException_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowTeamActivity_Should_ThrowException_When_PassMoreArgument() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(team.getName());
        list.add("MoreArguments");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowTeamActivity_Should_ShowAllBoardsActivity_When_PassExpectedArguments() {
        List<String> list = new ArrayList<>();
        list.add(team.getName());
        //Act
        command.execute(list);
        System.out.println(teamsController.showTeamActivity(team.getName()));

        //Assert
        Assertions.assertEquals(0, team.getTeamMembers().size());
    }
}
