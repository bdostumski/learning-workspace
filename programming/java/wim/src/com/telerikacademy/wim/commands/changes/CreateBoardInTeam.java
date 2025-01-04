package com.telerikacademy.wim.commands.changes;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.models.contracts.Board;

import java.util.List;

public class CreateBoardInTeam implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private static final String FAILED_TO_PARSE_BOARD_TO_TEAM_COMMAND_PARAMETERS =
            "Failed to parse Board to Team command parameters.";
    private static final String SUCCESSFULLY_ADDED_BOARD_TO_TEAM = "successfully added board to team";

    private final TeamsController teamsController;
    private final WimFactory factory;
    String boardName, teamName;

    public CreateBoardInTeam(TeamsController controller, WimFactory factory) {
        teamsController = controller;
        this.factory = factory;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        Board board = factory.createNewBoard(boardName);
        teamsController.assignBoardToTeam(board, teamName);
        return SUCCESSFULLY_ADDED_BOARD_TO_TEAM;
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            boardName = parameters.get(0);
            teamName = parameters.get(1);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_BOARD_TO_TEAM_COMMAND_PARAMETERS);
        }
    }
}