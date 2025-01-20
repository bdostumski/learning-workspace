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
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.StoryImpl;
import com.telerikacademy.wim.models.items.contracts.Bug;
import com.telerikacademy.wim.models.items.contracts.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowMemberActivity_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;

    private Team team;
    private Board board;
    private Member member;
    private Bug bug;
    private Story story;

    @BeforeEach
    public void before() {
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);

        member = new MemberImpl("MemberName");
        team = new TeamImpl("TeamName");
        board = new BoardImpl("BoardName");
        bug = new BugImpl("Bug Title-title", "Description", PriorityType.HIGH, SeverityType.MAJOR);
        story = new StoryImpl("Story Title-title", "Descripiton", PriorityType.HIGH, SizeType.SMALL);

        itemsController.addNewWorkItem(bug);
        itemsController.addNewWorkItem(story);
        membersController.addNewMember(member);
        teamsController.addNewTeam(team);

        team.addMemberToTeam(member);
        team.addBoardToTeam(board);

        member.addWorkItem(bug);
        member.addWorkItem(story);
        member.removeWorkItem(bug);

        command = new ShowMemberActivity(membersController);
    }

    @Test
    public void ShowMemberActivity_Should_ThrowException_When_PassedLessArguments() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(team.getName());

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowMemberActivity_Should_ThrowException_When_PassMoreArgument() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(team.getName());
        list.add(board.getName());
        list.add("MoreArguments");

        //Act & Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> command.execute(list));
    }

    @Test
    public void ShowMemberActivity_Should_ShowMemberActivity_When_PassExpectedArguments() {
        List<String> list = new ArrayList<>();
        list.add(member.getName());

        //Act
        command.execute(list);
        System.out.println(membersController.showMemberActivity(member.getName()));

        //Assert
        Assertions.assertEquals(3, member.getActivityHistory().size());
    }

}
