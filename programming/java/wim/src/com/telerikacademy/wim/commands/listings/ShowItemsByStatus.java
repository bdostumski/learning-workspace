package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.BugStatusType;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.Bug;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;
import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class ShowItemsByStatus implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 1;
    private static final String FAILED_TO_PARSE_BUG_BY_STATUS_COMMAND_PARAMETERS =
            "Failed to parse Show Bugs By Status command parameters.";
    private List<WorkingItems> itemsList;
    private WorkItemsController controller;
    private String statusFilter;

    public ShowItemsByStatus(WorkItemsController controller) {
        itemsList = new ArrayList<>();
        this.controller = controller;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        itemsList = controller.getAllWorkingItems().stream()
                .filter(item -> item.getStatusString().toLowerCase().equals(statusFilter.toLowerCase()))
                .collect(Collectors.toList());

        if (itemsList.size() == 0) {
            return "There are no registered items with such status yet.";
        }
        List<String> itemsList = workingItemsToString();

        return String.join(JOIN_DELIMITER + System.lineSeparator(), itemsList).trim();

    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            statusFilter = parameters.get(0);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_BUG_BY_STATUS_COMMAND_PARAMETERS);
        }
    }

    private List<String> workingItemsToString() {
        List<String> stringifiedWorkingItems = new ArrayList<>();
        for (WorkingItems item : itemsList) {
            stringifiedWorkingItems.add(item.toString());
        }
        return stringifiedWorkingItems;
    }
}
