package com.telerikacademy.wim.models.contracts;

import java.io.Serializable;
import java.util.List;

public interface Team extends Serializable {

    List<Member> getTeamMembers();

    List<Board> getTeamBoards();

    void addMemberToTeam(Member member);

    void removeMemberFromTeam(Member member);

    void addBoardToTeam(Board board);

    void removeBoardFromTeam(Board board);

    String getName();

    String showTeamMembers();

    String showTeamBoards();

    String teamActivity();

    Board getThisBoardFromTeam(String boardName);
}
