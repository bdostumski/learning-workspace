package com.telerikacademy.wim.models.items.contracts;

import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.contracts.Member;

import java.io.Serializable;

public interface CommonDetails extends WorkingItems, Serializable {

    PriorityType getPriority();

    void changePriority(PriorityType priorityType);

    Member getAssignee();

    void changeAssignee (Member member);

}
