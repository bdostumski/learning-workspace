package com.telerikacademy.wim.commands.changes;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.commands.contracts.Command;

import java.util.List;

public class UnAssignWorkItemToMember implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String SUCCESSFULLY_UN_ASSIGN_WORKING_ITEM_TO_MEMBER = "successfully un-assign working item to member";
    private static final String FAILED_TO_PARSE_UN_ASSIGN_WORKING_ITEMS_TO_MEMBER_COMMAND_PARAMETERS = "Failed to parse Un Assign WorkingItems to Member command parameters.";

    private final MembersController membersController;
    private String memberName;
    private int itemId;

    public UnAssignWorkItemToMember(MembersController controller) {
        membersController = controller;
    }

    @Override
    public String execute(List<String> parameters) {

        validateInput(parameters);
        parseParameters(parameters);

        membersController.unassignWorkItemToMember(memberName, itemId);

        return SUCCESSFULLY_UN_ASSIGN_WORKING_ITEM_TO_MEMBER;
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            memberName = parameters.get(0);
            itemId = Integer.parseInt(parameters.get(1));
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_UN_ASSIGN_WORKING_ITEMS_TO_MEMBER_COMMAND_PARAMETERS);
        }
    }

}
