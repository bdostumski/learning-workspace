package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;

import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class AssignMemberToTeam implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String SUCCESSFULLY_ADDED_MEMBER_TO_TEAM = "successfully added member to team";

    private final TeamsController teamsController;
    private String teamName, memberName;

    public AssignMemberToTeam(TeamsController controller) {
        teamsController = controller;
    }

    @Override
    public String execute(List<String> parameters) {

        validateInput(parameters);
        parseParameters(parameters);

        teamsController.assignTeamMemberToTeam(teamName, memberName);

       return SUCCESSFULLY_ADDED_MEMBER_TO_TEAM;
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            teamName = parameters.get(0);
            memberName = parameters.get(1);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse Assign Member to Team command parameters.");
        }
    }
}
