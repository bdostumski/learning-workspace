package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.CommonDetails;
import com.telerikacademy.wim.models.contracts.Member;

import java.io.Serializable;

import static com.telerikacademy.wim.models.common.Constants.NULL_ASSIGNEE_ERROR;
import static com.telerikacademy.wim.models.common.Validator.validateArgumentIsNotNull;

public abstract class CommonDetailsImpl extends WorkingItemsImpl implements CommonDetails, Serializable {

    private PriorityType priority;
    private Member assignee;

    public CommonDetailsImpl(String title,
                             String description,
                             PriorityType priority,
                             WorkingItemsType type) {

        super(title, description, type);
        this.priority = priority;
        assignee = new EmptyMemberInfo();
    }

    @Override
    public PriorityType getPriority() {
        return priority;
    }

    @Override
    public void changePriority(PriorityType priorityType) {
        this.priority = priorityType;
    }

    @Override
    public Member getAssignee() {
        return assignee;
    }

    @Override
    public void changeAssignee(Member assignee) {
        setAssignee(assignee);
    }

    private void setAssignee(Member assignee) {
        validateArgumentIsNotNull(assignee, NULL_ASSIGNEE_ERROR);
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Priority: %s%n" +
                "Member: %s%n",
                super.toString(), priority, getAssignee().getName());
    }

}
