package com.telerikacademy.wim.models;

import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BoardClass_Test {

    private WorkingItems testItem;
    private Board testBoard;

    @BeforeEach
    public void before() {
        testItem = new BugImpl("thisIsTestBug", "This is a test bug", PriorityType.HIGH, SeverityType.MAJOR);
        testBoard = new BoardImpl("TestBoard");
    }

    @Test
    public void add_method_should_add_item_to_list() {

        //Act
        testBoard.addWorkItem(testItem);
        //Assert
        Assertions.assertEquals(1, testBoard.getWorkItems().size());
    }

    @Test
    public void add_method_should_throw_when_item_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testBoard.addWorkItem(null));;
    }

    @Test
    public void add_method_should_throw_when_item_already_exists() {

        testBoard.addWorkItem(testItem);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testBoard.addWorkItem(testItem));;
    }

    @Test
    public void remove_method_should_remove_item_to_list() {

        //Act
        testBoard.addWorkItem(testItem);
        testBoard.removeWorkItem(testItem);
        //Assert
        Assertions.assertEquals(0, testBoard.getWorkItems().size());
    }

    @Test
    public void remove_method_should_throw_when_item_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testBoard.removeWorkItem(null));;
    }

    @Test
    public void add_method_should_throw_when_item_not_found() {


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testBoard.removeWorkItem(testItem));;
    }

    @Test
    public void add_and_remove_method_should_update_history() {

        //Act
        testBoard.addWorkItem(testItem);
        testBoard.removeWorkItem(testItem);
        //Assert
        Assertions.assertEquals(2, testBoard.getActivityHistory().size());
    }


    @Test
    public void constructor_should_trrow_when_name_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BoardImpl(null));
    }

    @Test
    public void constructor_should_trrow_when_name_longer() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BoardImpl("abcabcabcabcabcabcabcbabcabcabcabcabcabca"));
    }

    @Test
    public void constructor_should_trrow_when_name_shorter() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new BoardImpl("abc"));
    }
}
