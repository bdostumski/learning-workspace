package com.telerikacademy.wim.models.contracts;

import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.io.Serializable;
import java.util.List;

public interface Member extends Serializable {

    List<WorkingItems> getWorkItems();

    List<String> getActivityHistory();

    void addWorkItem(WorkingItems item);

    void removeWorkItem(WorkingItems item);

    void addToHistory(String action);

    String getName();

    String showHistory();

    String showWorkItems();


}
