package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.TeamsControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.TeamImpl;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowAllTeams_Test {

    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController itemsController;
    private Command command;

    @BeforeEach
    public void before(){
        itemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(itemsController);
        teamsController = new TeamsControllerImpl(membersController);


    }

    @Test
    public void show_all_members_should_show_members_list(){


        List<String> params = new ArrayList<>();
        params.add("TestTeam");

        Team testTeam = new TeamImpl("TestTeam");
        Member testMember = new MemberImpl("TestMember");
        teamsController.addNewTeam(testTeam);
        membersController.addNewMember(testMember);
        testTeam.addMemberToTeam(testMember);

        ShowAllTeams showAllTeams = new ShowAllTeams(teamsController);

        Assertions.assertNotNull(showAllTeams.execute(params));

    }

    @Test
    public void show_all_members_should_show_error_message_when_no_members_found(){


        List<String> params = new ArrayList<>();

        ShowAllTeams showAllTeams = new ShowAllTeams(teamsController);

        Assertions.assertEquals("There are no registered teams yet.", showAllTeams.execute(params));

    }
}
