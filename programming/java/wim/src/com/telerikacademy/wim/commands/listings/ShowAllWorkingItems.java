package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class ShowAllWorkingItems implements Command {


    private List<WorkingItems> itemsList;

    public ShowAllWorkingItems(WorkItemsController controller) {
        itemsList = controller.getAllWorkingItems();
    }

    @Override
    public String execute(List<String> parameters) {

        if (itemsList.size() == 0) {
            return "There are no registered Items to work on yet.";


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
