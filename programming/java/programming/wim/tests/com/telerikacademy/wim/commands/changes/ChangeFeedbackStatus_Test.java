package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.enums.FeedBackStatusType;
import com.telerikacademy.wim.models.items.FeedBackImpl;
import com.telerikacademy.wim.models.items.contracts.FeedBack;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ChangeFeedbackStatus_Test {

    private WorkItemsController controller;
    private Command command;

    FeedBack feedBack;

    @BeforeEach
    public void beforeEach() {


        feedBack = new FeedBackImpl("Title-title-title", "Description", 1);
        controller = new WorkItemsControllerImpl();
        List<WorkingItems> feedBacks = new ArrayList<>();
        feedBacks.add(feedBack);

        controller.updateItemsData(feedBacks);

        command = new ChangeFeedbackStatus(controller);

    }

    @Test
    public void ChangeFeedbackStatus_CheckStatus() {
        //Act & Assert
        Assertions.assertEquals(FeedBackStatusType.NEW, feedBack.getFeedBackStatusType());
    }

    @Test
    public void ChangeBugPriority_CheckChangedPriority() {
        //Arrange
        List<String> list = new ArrayList<>();
        list.add(String.format("%d", feedBack.getId()));
        list.add(FeedBackStatusType.DONE.toString());


        //Act
        command.execute(list);

        //Assert
        Assertions.assertEquals(FeedBackStatusType.DONE, feedBack.getFeedBackStatusType());
    }

}
