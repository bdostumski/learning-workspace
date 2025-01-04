package com.telerikacademy.wim.commands;

import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimRepository;
import java.io.IOException;


public class ExitCommand  {

    private WimRepository wimRepository;
    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController workItemsController;

    public ExitCommand(TeamsController teamsController,MembersController membersController,
                       WorkItemsController itemsController, WimRepository repository) {
        this.wimRepository = repository;
        this.workItemsController = itemsController;
        this.membersController = membersController;
        this.teamsController =teamsController;
    }


    public void execute() throws IOException {

        System.out.println("Saving Data...");
            wimRepository.saveTeamsInfoToDatabase(teamsController.getAllTeams());
            wimRepository.saveMembersDataToDatabase(membersController.getAllMembers());
            wimRepository.saveWorkkingItemsDataToDatabase(workItemsController.getAllWorkingItems());
//            wimRepository.saveBugsDataToDatabase(workItemsController.getAllBugs());
//            wimRepository.saveStoriesDataToDatabase(workItemsController.getAllStories());
//            wimRepository.saveFeedbacksDataToDatabase(workItemsController.getAllFeedbacks());

        System.out.println("Data Saved!");

            System.exit(0);

    }

}

