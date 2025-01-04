package com.telerikacademy.wim.commands.changes;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.commands.contracts.Command;

import java.util.List;

public class ShowMemberActivity implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String FAILED_TO_PARSE_SHOW_MEMBER_ACTIVITY_COMMAND_PARAMETERS =
            "Failed to parse Show Member Activity command parameters.";

    private MembersController membersController;
    private String memberName;

    public ShowMemberActivity(MembersController controller) {
        membersController = controller;    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        return membersController.showMemberActivity(memberName);
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            memberName = parameters.get(0);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_SHOW_MEMBER_ACTIVITY_COMMAND_PARAMETERS);
        }
    }
}