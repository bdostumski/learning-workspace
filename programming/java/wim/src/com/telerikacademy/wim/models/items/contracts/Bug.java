package com.telerikacademy.wim.models.items.contracts;

import com.telerikacademy.wim.models.common.enums.BugStatusType;
import com.telerikacademy.wim.models.common.enums.SeverityType;

import java.io.Serializable;
import java.util.List;

public interface Bug extends CommonDetails, Serializable {

    List<String> getStepsToReproduce();

    void addStepsToReproduce(String addStepsToReproduce);

    void removeStepsToReproduce(String removeStepsToReproduce);

    SeverityType getSeverityType();

    void changeSeverityType(SeverityType severityType);

    BugStatusType getBugStatusType();

    void changeStatusType(BugStatusType bugStatusType);

}
