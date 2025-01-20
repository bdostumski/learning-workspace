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

public class ShowAllTeamMembers_Test {

    private Command command;
    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;

    private Team team;
    private Board board;
    private Member member;
    private Member member1;

    @BeforeEach
    public void before() {

        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);

        member = new MemberImpl("MemberName");
        member1 = new MemberImpl("MemberName1");
        team = new TeamImpl("TeamName");
        board = new BoardImpl("BoardName");

        team.addMemberToTeam(member);
        team.addMemberToTeam(member1);
        team.addBoardToTeam(board);

        teamsController.addNewTeam(team);

        command = new ShowAllTeamMembers(teamsController);

    }

    @Test
    public void ShowAllTeamMembers_Should_ThrowException_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowAllTeamMember_Should_ThrowException_When_PassMoreArgument() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowAllTeamMembers_Should_ShowAllTeamMembers_When_PassExpectedArguments() {
        List<String> list = new ArrayList<>();
        list.add(team.getName());

        //Act
        command.execute(list);
//        System.out.println(controller.showTeamMebers(team.getName()));


        //Assert
        Assertions.assertEquals(2, team.getTeamMembers().size());
    }

}
