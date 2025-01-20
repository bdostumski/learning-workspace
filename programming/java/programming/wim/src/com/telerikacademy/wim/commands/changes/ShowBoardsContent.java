package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;

import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class ShowBoardsContent implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String FAILED_TO_PARSE_SHOW_BOARDS_ACTIVITY_COMMAND_PARAMETERS =
            "Failed to parse Show Boards Content command parameters.";

    private TeamsController teamsController;
    private String teamName, boardName;

    public ShowBoardsContent(TeamsController controller) {
        teamsController = controller;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        return teamsController.showBoardsContent(teamName, boardName);

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
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_SHOW_BOARDS_ACTIVITY_COMMAND_PARAMETERS);
        }
    }
}
