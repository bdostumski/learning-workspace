package com.telerikacademy.wim.commands.changes;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.MembersController;

import java.util.List;

public class AssignWorkItemToMember implements Command {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String FAILED_TO_PARSE_ASSIGN_MEMBER_TO_TEAM_COMMAND_PARAMETERS =
            "Failed to parse Assign Member to Team command parameters.";
    private static final String SUCCESSFULLY_ADDED_MEMBER_TO_TEAM = "successfully added member to team";

    private final MembersController membersController;

    private String memberName;
    private int workingItemId;

    public AssignWorkItemToMember(MembersController controller) {
        membersController = controller;
    }

    @Override
    public String execute(List<String> parameters) {

        validateInput(parameters);
        parseParameters(parameters);
        membersController.assignWorkItemToMember(memberName, workingItemId);

        return SUCCESSFULLY_ADDED_MEMBER_TO_TEAM;
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            memberName = parameters.get(0);
            workingItemId = Integer.parseInt(parameters.get(1));
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_ASSIGN_MEMBER_TO_TEAM_COMMAND_PARAMETERS);
        }
    }
}