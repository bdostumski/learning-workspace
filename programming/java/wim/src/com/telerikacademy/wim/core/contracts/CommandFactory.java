package com.telerikacademy.wim.core.contracts;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;

public interface CommandFactory {

    Command createCommand(String commandTypeAsString, WimFactory wimFactory,
                          MembersController membersController, TeamsController teamsController, WorkItemsController itemsController);
}
