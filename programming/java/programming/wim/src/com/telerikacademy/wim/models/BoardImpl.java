package com.telerikacademy.wim.models;

import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BoardImpl implements Board, Serializable {

    private String name;
    private List<WorkingItems> itemsList;
    private List<String> activityHistory;

    public BoardImpl(String name) {
        setName(name);
        itemsList = new ArrayList<>();
        activityHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.validateArgumentIsNotNull(name, "Board name can't be null");
        Validator.validateIntRange(name.length(), 5, 10, "Boar name should be between 5 & 10 chars");
        this.name = name;
    }

    @Override
    public List<WorkingItems> getWorkItems() {
        return itemsList;
    }

    @Override
    public List<String> getActivityHistory() {
        return activityHistory;
    }

    @Override
    public void addWorkItem(WorkingItems item) {
        Validator.validateArgumentIsNotNull(item, "Iteam can't be null");
        if (!itemsList.contains(item)) {
            itemsList.add(item);
            addToHistory("Added: " + item.getTitle());
        } else {
            addToHistory("Tried to add: " + item.getTitle() + " but it was already on the board");
            throw new IllegalArgumentException("This item is already on this board");
        }
    }

    @Override
    public void removeWorkItem(WorkingItems item) {
        Validator.validateArgumentIsNotNull(item, "Iteam can't be null");
        if (itemsList.contains(item)) {
            itemsList.remove(item);
            addToHistory("Removed: " + item.getTitle());
        } else {
            addToHistory("Tried to remove: " + item.getTitle() + " but it was not found in the board");
            throw new IllegalArgumentException("This item was not found on this board");
        }
    }

    @Override
    public void addToHistory(String action) {
        activityHistory.add(action);
    }

    @Override
    public String showActivity() {
        String result = "History ";
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("For board: ").append(getName()).append("\n");
        int index = 1;
        for (String str : activityHistory) {
            sb.append(index).append(". ").append(str).append("\n");
            index++;
        }
        result = sb.toString();
        return result;
    }

    @Override
    public String showWorkItems() {
        String result = "Work Items" + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("For board: ").append(getName()).append("\n");
        for (WorkingItems item : itemsList) {
            sb.append(item.getId()).append(". ").append(item.getTitle()).append("\n");
        }
        result = sb.toString();
        return result;
    }
}
