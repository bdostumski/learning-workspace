package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.Bug;
import com.telerikacademy.wim.models.items.contracts.Story;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class SortStoryBySize implements Command {

    private List<WorkingItems> itemsList;
    private WorkItemsController controller;

    public SortStoryBySize(WorkItemsController controller) {
        itemsList = new ArrayList<>();
        this.controller = controller;
    }

    @Override
    public String execute(List<String> parameters) {

        Comparator<WorkingItems> byName = Comparator.comparing(WorkingItems::getTitle);
        Comparator<Story> bySize = Comparator.comparing(Story::getStorySizeType).thenComparing(Story::getStoryStatusType);


        itemsList = controller.getAllWorkingItems().stream()
                .filter(item -> item.getItemsType() == WorkingItemsType.STORY)
                .sorted(byName)
                .map(i -> (Story) i )
                .sorted(bySize)
                .collect(Collectors.toList());

        if (itemsList.size() == 0) {
            return "There are no registered stories yet.";
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
