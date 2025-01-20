package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class CreateBugInquiryInBoard implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 6;
    private static final String SUCCESSFULLY_ADDED_BUG_INQUIRY_TO_BOARD = "Successfully added bug inquiry to board";
    private static final String FAILED_TO_PARSE_CREATE_BUG_INQUIRY_COMMAND_PARAMETERS =
            "Failed to parse Create Bug Inquiry command parameters.";

    private final TeamsController teamsController;
    private final WorkItemsController itemsController;
    private final WimFactory factory;

    private String teamName, boardName, bugTitle, bugDescription, bugPriority, bugSeverity;

    public CreateBugInquiryInBoard(TeamsController controller,WorkItemsController itemsController, WimFactory factory) {
        this.factory = factory;
        teamsController = controller;
        this.itemsController = itemsController;

    }

    @Override
    public String execute(List<String> parameters) {

        validateInput(parameters);
        parseParameters(parameters);
        WorkingItems item = factory.createNewBug(bugTitle, bugDescription, bugPriority, bugSeverity);
        itemsController.addNewWorkItem(item);
        teamsController.createWorkItemInBoard(teamName, boardName, item);

        return SUCCESSFULLY_ADDED_BUG_INQUIRY_TO_BOARD;
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
            bugTitle = parameters.get(2);
            bugDescription = parameters.get(3);
            bugPriority = parameters.get(4);
            bugSeverity = parameters.get(5);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_CREATE_BUG_INQUIRY_COMMAND_PARAMETERS);
        }
    }
}
