package com.telerikacademy.wim.controllers;

import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.items.EmptyMemberInfo;
import com.telerikacademy.wim.models.items.contracts.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WorkItemsControllerImpl implements WorkItemsController {

    private final List<WorkingItems> itemsList;


    public WorkItemsControllerImpl() {
        itemsList = new ArrayList<>();

    }

    @Override
    public void updateItemsData(List<WorkingItems> itemsData) {
        itemsList.clear();
        itemsList.addAll(itemsData);
    }

    @Override
    public void addNewWorkItem(WorkingItems item) {
        itemsList.add(item);
    }

    @Override
    public void addCommentToWorkItem(int itemId, Comment comment) {
        getWorkingItem(itemId).addComments(comment);
    }

    @Override
    public Bug getThisBugFromData(int id) {
        Validator.validateArgumentIsNotNull(id, "id can't be null");
        Optional<WorkingItems> matchingItem = itemsList.stream().
                filter(item -> item.getItemsType() == WorkingItemsType.BUG).
                filter(item -> item.getId() == id).
                findFirst();

        return (Bug) matchingItem.orElseThrow(() -> new IllegalArgumentException("No such bug found"));

    }

    @Override
    public Story getThisStoryFromData(int id) {
        Validator.validateArgumentIsNotNull(id, "id can't be null");
        Optional<WorkingItems> matchingItem = itemsList.stream().
                filter(item -> item.getItemsType() == WorkingItemsType.STORY).
                filter(item -> item.getId() == id).
                findFirst();

        return (Story) matchingItem.orElseThrow(() -> new IllegalArgumentException("No such story found"));

    }

    @Override
    public FeedBack getThisFeedbackFromData(int id) {
        Validator.validateArgumentIsNotNull(id, "id can't be null");
        Optional<WorkingItems> matchingItem = itemsList.stream().
                filter(item -> item.getItemsType() == WorkingItemsType.FEEDBACK).
                filter(item -> item.getId() == id).
                findFirst();

        return (FeedBack) matchingItem.orElseThrow(() -> new IllegalArgumentException("No such feedback found"));

    }

    @Override
    public List<WorkingItems> getAllWorkingItems() {
        return new ArrayList<>(itemsList);
    }

    public WorkingItems getWorkingItem(int id) {
        Validator.validateArgumentIsNotNull(id, "id can't be null");
        Optional<WorkingItems> matchingItem = itemsList.stream().
                filter(item -> item.getId() == id).
                findFirst();

        return matchingItem.orElseThrow(() -> new IllegalArgumentException("No such item found"));
    }


    public void setAsignee(WorkingItems item, Member member) {
        if (item.getItemsType().equals(WorkingItemsType.BUG)) {
            ((Bug) item).changeAssignee(member);
        } else if (item.getItemsType().equals(WorkingItemsType.BUG)) {
            ((Story) item).changeAssignee(member);
        } else {
            throw new IllegalArgumentException("Item must be a bug or story, to assign it a member");
        }
    }

    @Override
    public void removeAsignee(WorkingItems item, Member member) {
        Member noMember =new EmptyMemberInfo();
        if (item.getItemsType().equals(WorkingItemsType.BUG)) {
            ((Bug) item).changeAssignee(noMember);
        } else if (item.getItemsType().equals(WorkingItemsType.BUG)) {
            ((Story) item).changeAssignee(noMember);
        } else {
            throw new IllegalArgumentException("Item must be a bug or story, to assign it a member");
        }
    }
}
