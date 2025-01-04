package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class ShowBugsOnly implements Command {

    private List<WorkingItems> itemsList;
    private WorkItemsController workItemsController;

    public ShowBugsOnly(WorkItemsController controller) {
        itemsList = new ArrayList<>();
        workItemsController = controller;

    }

    @Override
    public String execute(List<String> parameters) {

        itemsList = workItemsController.getAllWorkingItems().stream()
                .filter(item -> item.getItemsType() == WorkingItemsType.BUG)
                .collect(Collectors.toList());

        if (itemsList.size() == 0) {
            return "There are no registered bugs yet.";
        }
        List<String> itemsList = workingItemsToString();

        return String.join(JOIN_DELIMITER + System.lineSeparator(), itemsList).trim();

    }

    private List<String> workingItemsToString() {
        List<String> stringifiedWorkingItems = new ArrayList<>();
        for (WorkingItems item : itemsList) {
            stringifiedWorkingItems.add(item.toString());
        }
        return stringifiedWorkingItems;
    }

}



