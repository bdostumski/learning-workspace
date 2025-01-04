package com.telerikacademy.wim.controllers.contracts;

import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.List;

public interface TeamsController {

    void updateTeamsData(List<Team> teamsData);

    void addNewTeam(Team team);

    List<Team> getAllTeams ();

    String showTeamActivity (String teamName);

    String showTeamMebers (String teamName);

    String showTeamBoards (String teamName);

    String showBoardsActivity (String teamName, String boardName);

    String showBoardsContent (String teamName, String boardName);

    void assignBoardToTeam(Board boardToAssign, String teamName);

    void assignTeamMemberToTeam(String targetedTeamName, String teamMemberName);

    void createWorkItemInBoard(String teamName, String boardName, WorkingItems item);
}
