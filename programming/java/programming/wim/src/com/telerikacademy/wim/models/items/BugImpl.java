package com.telerikacademy.wim.models.items;

import static com.telerikacademy.wim.models.common.Constants.LIST_DOES_NOT_CONTAIN_STEPS_TO_REPRODUCE;
import static com.telerikacademy.wim.models.common.Constants.NULL_STEPS_REPRODUCE_ERROR;
import static com.telerikacademy.wim.models.common.Validator.checkListNotContainsValue;
import com.telerikacademy.wim.models.common.enums.BugStatusType;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.Bug;
import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.contracts.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BugImpl extends CommonDetailsImpl implements Bug, Serializable {

    private List<String> stepsToReproduce;
    private SeverityType severityType;
    private BugStatusType bugStatusType;

    public BugImpl(String title,
                   String description,
                   PriorityType priority,
                   SeverityType severityType) {

        super(title, description, priority, WorkingItemsType.BUG);
        this.severityType = severityType;
        this.bugStatusType = BugStatusType.ACTIVE;
        stepsToReproduce = new ArrayList<>();
    }

    @Override
    public List<String> getStepsToReproduce() {
        return new ArrayList<>(stepsToReproduce);
    }

    @Override
    public void addStepsToReproduce(String addStepsToReproduce) {
        Validator.validateArgumentIsNotNull(addStepsToReproduce, NULL_STEPS_REPRODUCE_ERROR);
        stepsToReproduce.add(addStepsToReproduce);
    }

    @Override
    public void removeStepsToReproduce(String removeStepsToReproduce) {
        checkListNotContainsValue(stepsToReproduce, removeStepsToReproduce, LIST_DOES_NOT_CONTAIN_STEPS_TO_REPRODUCE);
        stepsToReproduce.remove(removeStepsToReproduce);
    }

    @Override
    public SeverityType getSeverityType() {
        return severityType;
    }

    @Override
    public void changeSeverityType(SeverityType severityType) { this.severityType = severityType; }

    @Override
    public BugStatusType getBugStatusType() { return bugStatusType; }

    @Override
    public void changeStatusType(BugStatusType bugStatusType) { this.bugStatusType = BugStatusType.FIXED; }

    @Override
    public void changeAssignee(Member assignee) { super.changeAssignee(assignee); }

    @Override
    public Member getAssignee() { return super.getAssignee(); }

    @Override
    public String getStatusString() {
       return bugStatusType.toString();
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Steps to reproduce: %s%n" +
                "Severity: %s%n" +
                "Status: %s%n",
                super.toString(), stepsToReproduce, severityType, bugStatusType);
    }
}
