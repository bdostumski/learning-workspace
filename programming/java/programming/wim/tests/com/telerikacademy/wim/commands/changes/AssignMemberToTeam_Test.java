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
import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.TeamImpl;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AssignMemberToTeam_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;

    private Member member;
    private Team team;

    @BeforeEach
    public void beforeEach() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);


        team = new TeamImpl("TeamName");
        member = new MemberImpl("MemberName");

        List<Team> teams = new ArrayList<>();
        teams.add(team);

        List<Member> members = new ArrayList<>();
        members.add(member);

        membersController.updateMembersData(members);
        teamsController.updateTeamsData(teams);
        command = new AssignMemberToTeam(teamsController);
    }


    @Test
    public void AssignMemberToTeam__Should_AssignMemberToTeam_When_ValueIsValid() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(team.getName());
        list.add(member.getName());

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(1, team.getTeamMembers().size());
    }

    @Test
    public void AssignMemberToTeam_ShouldThrow_Exception_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void AssignMemberToTeam_ShouldThrow_Exception_When_PassedMoreArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add("Argument1");
        list.add("Argument2");
        list.add("Argument3");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

}
