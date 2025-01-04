package com.telerikacademy.wim.models;

import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamClass_Test {

    private Team testTeam;
    private Member testMember;
    private Board testBoard;

    @BeforeEach
    private void before(){
        testTeam = new TeamImpl("TestTeam");
        testMember = new MemberImpl("TestMember");
        testBoard = new BoardImpl("TestBoard");
    }

    @Test
    public void add_member_should_throw_when_member_null(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.addMemberToTeam(null));
    }

    @Test
    public void add_member_should_throw_when_member_already_present(){
        testTeam.addMemberToTeam(testMember);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.addMemberToTeam(testMember));
    }

    @Test
    public void add_member_should_add_new_member(){
        //Act
        testTeam.addMemberToTeam(testMember);
        //Assert
        Assertions.assertEquals(1, testTeam.getTeamMembers().size());
    }



    @Test
    public void remove_member_should_throw_when_member_null(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.removeMemberFromTeam(null));
    }

    @Test
    public void remove_member_should_throw_when_member_not_found(){

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.removeMemberFromTeam(testMember));
    }

    @Test
    public void remove_member_should_remove_member(){
        //Act
        testTeam.addMemberToTeam(testMember);
        testTeam.removeMemberFromTeam(testMember);
        //Assert
        Assertions.assertEquals(0, testTeam.getTeamMembers().size());
    }



    @Test
    public void add_board_should_throw_when_member_null(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.addBoardToTeam(null));
    }

    @Test
    public void add_board_should_throw_when_board_already_present(){
        testTeam.addBoardToTeam(testBoard);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.addBoardToTeam(testBoard));
    }

    @Test
    public void add_board_should_add_new_board(){
        //Act
        testTeam.addBoardToTeam(testBoard);
        //Assert
        Assertions.assertEquals(1, testTeam.getTeamBoards().size());
    }



    @Test
    public void remove_board_should_throw_when_board_null(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.removeBoardFromTeam(null));
    }

    @Test
    public void remove_board_should_throw_when_board_not_found(){

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> testTeam.removeBoardFromTeam(testBoard));
    }

    @Test
    public void remove_board_should_remove_board(){
        //Act
        testTeam.addBoardToTeam(testBoard);
        testTeam.removeBoardFromTeam(testBoard);
        //Assert
        Assertions.assertEquals(0, testTeam.getTeamBoards().size());
    }



    @Test
    public void constructor_should_trrow_when_name_null() {

        Assertions.assertThrows(IllegalArgumentException.class,
        () -> new TeamImpl(null));
    }

    @Test
    public void constructor_should_trrow_when_name_longer() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TeamImpl("abcabcabcabcabcabcabcbabcabcabcabcabcabca"));
    }

    @Test
    public void constructor_should_trrow_when_name_shorter() {

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new TeamImpl("abc"));
    }



}
