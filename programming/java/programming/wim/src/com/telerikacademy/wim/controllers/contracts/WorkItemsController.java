package com.telerikacademy.wim.controllers.contracts;

import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.items.contracts.*;

import java.util.List;

public interface WorkItemsController {

    void updateItemsData(List<WorkingItems> itemsData);

    void addNewWorkItem (WorkingItems item);

    void addCommentToWorkItem (int itemId, Comment comment);

    Bug getThisBugFromData (int id);

    Story getThisStoryFromData (int id);

    FeedBack getThisFeedbackFromData (int id);

    List<WorkingItems> getAllWorkingItems();

    void setAsignee(WorkingItems item, Member member );

    void removeAsignee(WorkingItems item, Member member );

    WorkingItems getWorkingItem(int id);

}
