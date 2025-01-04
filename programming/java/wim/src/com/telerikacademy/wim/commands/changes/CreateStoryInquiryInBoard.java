package com.telerikacademy.wim.commands.changes;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.core.contracts.WimFactory;

import java.util.List;

public class CreateStoryInquiryInBoard implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;
    private static final String FAILED_TO_PARSE_CREATE_STORY_INQUIRY_IN_BOARD_COMMAND_PARAMETERS =
            "Failed to parse Create Story Inquiry In Board command parameters.";
    private static final String SUCCESSFULLY_CREATED_STORY_INQUIRY_TO_BOARD = "Successfully created story inquiry to board";

    private final TeamsController teamsController;
    private final WorkItemsController itemsController;
    private final WimFactory factory;
    private String teamName;
    private String boardName;
    private String title;
    private String description;
    private String priority;
    private String size;

    public CreateStoryInquiryInBoard(TeamsController teamsController,WorkItemsController itemsController, WimFactory factory) {
        this.itemsController = itemsController;
        this.factory = factory;
        this.teamsController = teamsController;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        WorkingItems workingItems = factory.createNewStory(title, description, priority, size);
        itemsController.addNewWorkItem(workingItems);
        teamsController.createWorkItemInBoard(teamName, boardName, workingItems);
        return SUCCESSFULLY_CREATED_STORY_INQUIRY_TO_BOARD;
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            teamName = parameters.get(0);
            boardName = parameters.get(1);
            title = parameters.get(2);
            description = parameters.get(3);
            priority = parameters.get(4);
            size = parameters.get(5);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_CREATE_STORY_INQUIRY_IN_BOARD_COMMAND_PARAMETERS);
        }
    }
}
