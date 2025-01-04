package com.telerikacademy.wim.core.factories;

import com.telerikacademy.wim.commands.changes.*;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.commands.creation.CreateMemberCommand;
import com.telerikacademy.wim.commands.creation.CreateTeamCommand;
import com.telerikacademy.wim.commands.listings.*;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimFactory;
import gui.commands.CreateNewBoardGui;

import java.util.List;

public class CommandExecutor {

    public Command createMember (MembersController membersController, WimFactory factory)    {
        return new CreateMemberCommand(membersController, factory);
    }

    public Command createTeam (TeamsController teamsController, WimFactory factory)    {
        return new CreateTeamCommand(teamsController, factory);
    }

    public Command createNewBoard(TeamsController teamsController, WimFactory factory) {
        return new CreateBoardInTeam(teamsController, factory);
    }

    public Command createBug(TeamsController teamsController, WorkItemsController workItemsController, WimFactory factory) {
        return new CreateBugInquiryInBoard(teamsController, workItemsController, factory);
    }

    public Command createFeedBack(TeamsController teamsController, WorkItemsController workItemsController, WimFactory factory) {
        return new CreateFeedbackInquiryInBoard(teamsController, workItemsController, factory);
    }

    public Command createStory(TeamsController teamsController, WorkItemsController workItemsController, WimFactory factory) {
        return new CreateStoryInquiryInBoard(teamsController, workItemsController, factory);
    }

    public Command addCommentToWorkItem(WorkItemsController workItemsController) {
        return new AddCommentToWorkItem(workItemsController);
    }

    public Command assignMemberToTeam(TeamsController teamsController) {
        return new AssignMemberToTeam(teamsController);
    }

    public Command assignWorkToMember(MembersController membersController) {
        return new AssignWorkItemToMember(membersController);
    }

    public Command unAssignItemToMember(MembersController membersController) {
        return new UnAssignWorkItemToMember(membersController);
    }

    public Command changeBugPriority(WorkItemsController workItemsController) {
        return new ChangeBugPriority(workItemsController);
    }

    public Command changeBugSeverity(WorkItemsController workItemsController) {
        return new ChangeBugSeverity(workItemsController);
    }

    public Command changeBugStatus(WorkItemsController workItemsController) {
        return new ChangeBugStatus(workItemsController);
    }

    public Command changeFeedBackRating(WorkItemsController workItemsController) {
        return new ChangeFeedbackRating(workItemsController);
    }

    public Command changeFeedBackStatus(WorkItemsController workItemsController) {
        return new ChangeFeedbackStatus(workItemsController);
    }

    public Command changeStoryPriority(WorkItemsController workItemsController) {
        return new ChangeStoryPriority(workItemsController);
    }

    public Command changeStorySize(WorkItemsController workItemsController) {
        return new ChangeStorySize(workItemsController);
    }

    public Command changeStoryStatus(WorkItemsController workItemsController) {
        return new ChangeStoryStatus(workItemsController);
    }

    public Command showAllMembers (MembersController controller){
        return new ShowAllMembers(controller);
    }

    public Command showAllTeams (TeamsController controller){
        return new ShowAllTeams(controller);
    }

    public Command showAllBoards (TeamsController controller){
        return new ShowAllTeamBoards(controller);
    }

    public Command showAllWorkingItems(WorkItemsController itemsController){
        return new ShowAllWorkingItems(itemsController);
    }

    public Command showBugsOnly (WorkItemsController itemsController){
        return new ShowBugsOnly(itemsController);
    }

    public Command showFeedbacksOnly (WorkItemsController itemsController){
        return new ShowFeedbacksOnly(itemsController);
    }

    public Command showItemsByStatus (WorkItemsController itemsController) {
        return new ShowAllWorkingItems(itemsController);
    }

    public Command showBoardsActivity (TeamsController teamsController) {
        return new ShowBoardsActivity(teamsController);
    }

    public Command showMemberActivity (MembersController membersController) {
        return new ShowMemberActivity(membersController);
    }

    public Command showTeamActivity (TeamsController teamsController) {
        return new ShowTeamActivity(teamsController);
    }

    public Command showStoriesOnly (WorkItemsController itemsController){
        return new ShowStoriesOnly(itemsController);
    }

    public Command sortBugsBySeverity (WorkItemsController itemsController){
        return new SortBugsBySeverity(itemsController);
    }

    public Command sortsByPriority (WorkItemsController itemsController){
        return new SortByPriority(itemsController);
    }

    public Command sortFeedbacksByRating ( WorkItemsController itemsController){
        return new SortfeedbacksByRating(itemsController);
    }

    public Command sortsBySize(WorkItemsController itemsController){
        return new SortStoryBySize(itemsController);
    }

    public Command sortsByTitle(WorkItemsController itemsController){
        return new SortItemsByTitle(itemsController);
    }



}
