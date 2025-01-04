package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmptyMemberInfo implements Member, Serializable {

   private List<WorkingItems> emptyItemsList = new ArrayList<>();
   private List<String> emptyHistoryList = new ArrayList<>();


    public EmptyMemberInfo() {

    }

    @Override
    public List<WorkingItems> getWorkItems() {
        return emptyItemsList;
    }

    @Override
    public List<String> getActivityHistory() {
        return emptyHistoryList;
    }

    @Override
    public void addWorkItem(WorkingItems item) {
        throw new IllegalArgumentException("Can't add working item to empty member");
    }

    @Override
    public void removeWorkItem(WorkingItems item) {
        throw new IllegalArgumentException("Can't remove item from empty member");
    }

    @Override
    public void addToHistory(String action) {
        throw new IllegalArgumentException("Can't add history to empty member");
    }

    @Override
    public String getName() {
        return "No Member";
    }

    @Override
    public String showHistory() {
        return "No hitory on Nonexistent Member";
    }

    @Override
    public String showWorkItems() {
        return "No working items on Nonexistent Member";
    }
}
