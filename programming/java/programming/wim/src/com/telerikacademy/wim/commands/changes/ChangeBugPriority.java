package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.items.contracts.Bug;

import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class ChangeBugPriority implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 2;
    private final WorkItemsController itemsController;

    private int bugId;
    private String newPriority;

    public ChangeBugPriority(WorkItemsController controller) {
        itemsController = controller;
    }

    @Override
    public String execute(List<String> parameters) {

        validateInput(parameters);
        parseParameters(parameters);
        Bug bug = itemsController.getThisBugFromData(bugId);
        bug.changePriority(PriorityType.valueOf(newPriority.toUpperCase()));
        return "Bug priority updated successfully";
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            bugId = Integer.parseInt(parameters.get(0));
            newPriority = parameters.get(1);
        } catch (Exception e) {
            throw new IllegalArgumentException("Failed to parse Change Bug Priority command parameters.");
        }
    }
}
