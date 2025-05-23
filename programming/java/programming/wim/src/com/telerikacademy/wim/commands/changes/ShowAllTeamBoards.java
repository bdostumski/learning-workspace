package com.telerikacademy.wim.commands.changes;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.commands.contracts.Command;

import java.util.List;

public class ShowAllTeamBoards implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String FAILED_TO_PARSE_SHOW_ALL_TEAM_BOARDS_COMMAND_PARAMETERS =
            "Failed to parse Show All Team Boards command parameters.";

    private TeamsController teamsController;
    private String teamName;

    public ShowAllTeamBoards(TeamsController teamsController) {
        this.teamsController = teamsController;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        return teamsController.showTeamBoards(teamName);
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            teamName = parameters.get(0);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_SHOW_ALL_TEAM_BOARDS_COMMAND_PARAMETERS);
        }
    }
}