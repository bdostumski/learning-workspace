package com.telerikacademy.wim.commands.creation;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.models.contracts.Member;

import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class CreateMemberCommand implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private final MembersController membersController;
    private final WimFactory factory;
    private String name = "No Name";

    public CreateMemberCommand(MembersController controller, WimFactory factory) {
        membersController = controller;
        this.factory = factory;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        Member member = factory.createNewMember(name);
        membersController.addNewMember(member);

        return "Member successfully added!";
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
            throw new IllegalArgumentException("Failed to parse Create Member command parameters.");
        }
    }
}
