package com.telerikacademy.wim.core.factories;

import com.telerikacademy.wim.commands.changes.*;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.commands.creation.CreateMemberCommand;
import com.telerikacademy.wim.commands.creation.CreateTeamCommand;
import com.telerikacademy.wim.commands.listings.*;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.CommandFactory;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.core.providers.CommandType;

public class CommandFactoryImpl implements CommandFactory {

    private static final String INVALID_COMMAND = "Invalid command name: %s!";

    @Override
    public Command createCommand(String commandTypeAsString, WimFactory wimFactory,
                                 MembersController membersController, TeamsController teamsController, WorkItemsController itemsController) {

        CommandType commandType = CommandType.valueOf(commandTypeAsString.toUpperCase());
        switch (commandType) {
            case CREATETEAMMEMBER:
                return new CreateMemberCommand(membersController, wimFactory);
            case SHOWALLMEMBERS:
                return new ShowAllMembers(membersController);
            case SHOWMEMBERACTIVITY:
                return new ShowMemberActivity(membersController);
            case CREATETEAM:
                return new CreateTeamCommand(teamsController, wimFactory);
            case SHOWALLTEAMS:
                return new ShowAllTeams(teamsController);
            case SHOWTEAMACTIVITY:
                return new ShowTeamActivity(teamsController);
            case CREATENEWBOARD:
                return new CreateBoardInTeam(teamsController, wimFactory);
            case SHOWTEAMSBOARDS:
                return new ShowAllTeamBoards(teamsController);
            case SHOWBOARDACTIVITY:
                return new ShowBoardsActivity(teamsController);
            case CREATEBUG:
                return new CreateBugInquiryInBoard(teamsController, itemsController, wimFactory);
            case CREATESTORY:
                return new CreateStoryInquiryInBoard(teamsController, itemsController, wimFactory);
            case CREATEFEEDBACK:
                return new CreateFeedbackInquiryInBoard(teamsController,itemsController, wimFactory);
            case CHANGEBUGPRIORITY:
                return new ChangeBugPriority(itemsController);
            case CHANGEBUGSEVERITY:
                return new ChangeBugSeverity(itemsController);
            case CHANGEBUGSTATUS:
                return new ChangeBugStatus(itemsController);
            case CHANGESTORYSTATUS:
                return new ChangeStoryStatus(itemsController);
            case CHANGESTORYPRIORITY:
                return new ChangeStoryPriority(itemsController);
            case CHANGESTORYSIZE:
                return new ChangeStorySize(itemsController);
            case CHANGEFEEDBACKRATING:
                return new ChangeFeedbackRating(itemsController);
            case CHANGEFEEDBACKSTATUS:
                return new ChangeFeedbackStatus(itemsController);
            case ASSIGNWORKTOMEMBER:
                return new AssignWorkItemToMember(membersController);
            case ASSIGNMEMBERTOTEAM:
                return new AssignMemberToTeam(teamsController);
            case UNASSIGNWORKTOMEMBER:
                return new UnAssignWorkItemToMember(membersController);
            case ADDCOMMENTTOWORKITEM:
                return new AddCommentToWorkItem(itemsController);
            case LISTALLWORKITEMS:
                return new ShowAllWorkingItems(itemsController);
            case LISTBUGSONLY:
                return new ShowBugsOnly(itemsController);
            case LISTSTORIESONLY:
                return new ShowStoriesOnly(itemsController);
            case LISTFEEDBACKSONLY:
                return new ShowFeedbacksOnly(itemsController);
            case FILTERITEMSBYSTATUS:
                return new ShowItemsByStatus(itemsController);
            case SORTBYTITLE:
                return new SortItemsByTitle(itemsController);
            case SORTBYPRIORITY:
                return new SortByPriority(itemsController);
            case SORTBYSEVERITY:
                return new SortBugsBySeverity(itemsController);
            case SORTBYSIZE:
                return new SortStoryBySize(itemsController);
            case SORTBYRATING:
                return new SortfeedbacksByRating(itemsController);
            case SHOWALLTEAMMEMBERS:
                return new ShowAllTeamMembers(teamsController);
            case SHOWBOARDSCONTENT:
                return new ShowBoardsContent(teamsController);


        }
        throw new IllegalArgumentException(String.format(INVALID_COMMAND, commandTypeAsString));
    }



}
