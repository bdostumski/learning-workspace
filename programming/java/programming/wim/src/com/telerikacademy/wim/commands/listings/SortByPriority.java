package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.CommonDetails;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class SortByPriority implements Command {

    private List<CommonDetails> itemsList;
    private WorkItemsController controller;

    public SortByPriority(WorkItemsController controller) {
        itemsList = new ArrayList<>();
        this.controller = controller;
    }

    @Override
    public String execute(List<String> parameters) {

        Comparator<CommonDetails> byPriority = Comparator.comparing(CommonDetails::getPriority);

        itemsList = controller.getAllWorkingItems().stream()
                .filter(i -> !i.getItemsType().equals(WorkingItemsType.FEEDBACK))
                .map(item -> (CommonDetails) item)
                .sorted(byPriority)
                .collect(Collectors.toList());

        if (itemsList.size() == 0) {
            return "There are no registered priority items yet.";
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
