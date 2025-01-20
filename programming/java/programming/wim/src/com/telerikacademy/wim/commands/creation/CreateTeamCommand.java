package com.telerikacademy.wim.commands.creation;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.models.contracts.Team;

import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class CreateTeamCommand implements Command {


    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final TeamsController controller;
    private final WimFactory factory;
    private String name = "No Name";

    public CreateTeamCommand(TeamsController controller, WimFactory factory) {
        this.controller = controller;
        this.factory = factory;
    }

    @Override
    public String execute(List<String> parameters) {

        validateInput(parameters);
        parseParameters(parameters);

        Team team = factory.createNewTeam(name);
        controller.addNewTeam(team);

        return "Team successfully created!";
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            name = parameters.get(0);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse Create Team command parameters.");
        }
    }

}
