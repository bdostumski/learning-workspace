package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.contracts.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShowAllMembers_Test {


    @Test
    public void show_all_members_should_show_members_list(){

        WorkItemsController itemsController = new WorkItemsControllerImpl();
        MembersController membersController = new MembersControllerImpl(itemsController);

        List<String> params = new ArrayList<>();
        Member testMember = new MemberImpl("Test Member");
        membersController.addNewMember(testMember);
        ShowAllMembers showAllMembers = new ShowAllMembers(membersController);

        Assertions.assertNotNull(showAllMembers.execute(params));

    }

    @Test
    public void show_all_members_should_show_error_message_when_no_members_found(){

        WorkItemsController itemsController = new WorkItemsControllerImpl();
        MembersController membersController = new MembersControllerImpl(itemsController);

        List<String> params = new ArrayList<>();

        ShowAllMembers showAllMembers = new ShowAllMembers(membersController);

        Assertions.assertEquals("There are no registered members yet.", showAllMembers.execute(params));

    }

}
