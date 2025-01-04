package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.common.enums.BugStatusType;
import com.telerikacademy.wim.models.items.contracts.CommonDetails;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.items.contracts.Bug;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.telerikacademy.wim.models.common.Constants.*;

public class BugImpl_Test {

    @Test
    public void BugImpl_ShouldImplementBugInterface() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        //Assert
        Assertions.assertTrue(bug instanceof Bug);
    }

    @Test
    public void BugImpl_ShouldImplementCommonDetailsInterface() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        //Assert
        Assertions.assertTrue(bug instanceof CommonDetails);
    }

    @Test
    public void BugImpl_ShouldImplementWorkingItemInterface() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        //Assert
        Assertions.assertTrue(bug instanceof WorkingItems);
    }


    @Test
    public void Constructor_ShouldThrow_WhenTitleIsNull() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BugImpl(null, "description",
                        PriorityType.HIGH, SeverityType.MAJOR));
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsBelow10() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BugImpl(new String(new char[TITLE_MIN_LENGTH-1]), "description",
                        PriorityType.HIGH, SeverityType.MAJOR));
    }

    @Test
    public void Constructor_ShouldThrow_WhenTitleIsAbove50() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BugImpl(new String(new char[TITLE_MAX_LENGTH+1]), "description",
                        PriorityType.HIGH, SeverityType.MAJOR));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsNull() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BugImpl("title-title-title", null,
                        PriorityType.HIGH, SeverityType.MAJOR));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsBelow10() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BugImpl("title-title-title", new String(new char[DESCRIPTION_MIN_LENGTH-1]),
                        PriorityType.HIGH, SeverityType.MAJOR));
    }

    @Test
    public void Constructor_ShouldThrow_WhenDescriptionIsAbove50() {
        // Act
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BugImpl("title-title-title", new String(new char[DESCRIPTION_MAX_LENGTH+1]),
                        PriorityType.HIGH, SeverityType.MAJOR));
    }

    @Test
    public void Method_Add_StepsToReproduce_ShouldAddStepsToReproduce() {
        BugImpl bugImpl = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MINOR);
        bugImpl.addStepsToReproduce("Step1 to reproduce");
        Assertions.assertEquals(1, bugImpl.getStepsToReproduce().size());
    }

    @Test
    public void Method_Null_stepsToReproduce_ShouldThrowWhenStepsAre0() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MINOR);
        Assertions.assertEquals(0, bug.getStepsToReproduce().size());
    }

    @Test
    public void Method_Remove_StepsToReproduce_ShouldRemoveStepsToReproduce() {
        BugImpl bugImpl = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MINOR);
        bugImpl.addStepsToReproduce("Step1 to reproduce");
        bugImpl.addStepsToReproduce("Step2 to reproduce");
        bugImpl.removeStepsToReproduce("Step2 to reproduce");
        Assertions.assertEquals(1, bugImpl.getStepsToReproduce().size());
    }

    @Test
    public void Method_severityType_ShouldReturnSeverityType() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MINOR);
        Assertions.assertEquals(SeverityType.MINOR, bug.getSeverityType());
    }

    @Test
    public void Method_changeSeverityType_ShouldChangeSeverityType() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MINOR);
        bug.changeSeverityType(SeverityType.MAJOR);
        Assertions.assertEquals(SeverityType.MAJOR, bug.getSeverityType());
    }

    @Test
    public void Method_priorityType_ShouldPrintPriorityType() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        Assertions.assertEquals(PriorityType.HIGH, bug.getPriority());
    }

    @Test
    public void Method_changePriorityType_ShouldChangePriorityType() {
        BugImpl bug = new BugImpl("tittle-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        bug.changePriority(PriorityType.LOW);
        Assertions.assertEquals(PriorityType.LOW, bug.getPriority());
    }


    @Test
    public void Method_statusType_ShouldReturnStatusType() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        Assertions.assertEquals(BugStatusType.ACTIVE, bug.getBugStatusType());
    }

    @Test
    public void Method_changeStatusType_ShouldChangeStatusType() {
        BugImpl bug = new BugImpl("title-title-title", "description", PriorityType.HIGH, SeverityType.MAJOR);
        bug.changeStatusType(BugStatusType.FIXED);
        Assertions.assertEquals(BugStatusType.FIXED, bug.getBugStatusType());
    }

}
