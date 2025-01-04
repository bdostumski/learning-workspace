package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.common.enums.StoryStatusType;
import com.telerikacademy.wim.models.items.StoryImpl;
import com.telerikacademy.wim.models.items.contracts.Story;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChangeStoryStatus_Test {

    private WorkItemsController controller;
    private Command command;

    private Story story;

    @BeforeEach
    public void beforeEach() {
        controller = new WorkItemsControllerImpl();

        story = new StoryImpl("Title-title-title", "Description", PriorityType.HIGH, SizeType.SMALL);

        controller.addNewWorkItem(story);

        command = new ChangeStoryStatus(controller);
    }

    @Test
    public void ChangeStoryStatus_CheckStatus() {
        //Act & Assert
        Assertions.assertEquals(StoryStatusType.NOTDONE, story.getStoryStatusType());
    }

    @Test
    public void ChangeStoryStatus_CheckChangedStatus() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(String.format("%d", story.getId()));
        list.add(StoryStatusType.DONE.toString());

        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(StoryStatusType.DONE, story.getStoryStatusType());
    }
}
