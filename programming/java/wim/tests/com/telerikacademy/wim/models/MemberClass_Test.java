package com.telerikacademy.wim.models;

import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberClass_Test {

    private WorkingItems testItem;
    private Member testMember;

    @BeforeEach
    public void before() {
        testItem = new BugImpl("thisIsTestBug", "This is a test bug", PriorityType.HIGH, SeverityType.MAJOR);
        testMember = new MemberImpl("TestMember");
    }

    @Test
    public void add_method_should_add_item_to_list() {

        //Act
        testMember.addWorkItem(testItem);
        //Assert
        Assertions.assertEquals(1, testMember.getWorkItems().size());
    }

    @Test
    public void add_method_should_throw_when_item_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testMember.addWorkItem(null));;
    }

    @Test
    public void add_method_should_throw_when_item_already_exists() {

        testMember.addWorkItem(testItem);

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testMember.addWorkItem(testItem));;
    }

    @Test
    public void remove_method_should_remove_item_to_list() {

        //Act
        testMember.addWorkItem(testItem);
        testMember.removeWorkItem(testItem);
        //Assert
        Assertions.assertEquals(0, testMember.getWorkItems().size());
    }

    @Test
    public void remove_method_should_throw_when_item_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testMember.removeWorkItem(null));;
    }

    @Test
    public void add_method_should_throw_when_item_not_found() {


        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testMember.removeWorkItem(testItem));;
    }

    @Test
    public void add_and_remove_method_should_update_history() {

        //Act
        testMember.addWorkItem(testItem);
        testMember.removeWorkItem(testItem);
        //Assert
        Assertions.assertEquals(2, testMember.getActivityHistory().size());
    }

    @Test
    public void constructor_should_trrow_when_name_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MemberImpl(null));
    }

    @Test
    public void constructor_should_trrow_when_name_longer() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MemberImpl("abcabcabcabcabcabcabcbabcabcabcabcabcabca"));
    }

    @Test
    public void constructor_should_trrow_when_name_shorter() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new MemberImpl("abc"));
    }
}
