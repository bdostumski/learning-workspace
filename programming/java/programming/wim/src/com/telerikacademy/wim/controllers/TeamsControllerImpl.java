package com.telerikacademy.wim.controllers;

import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamsControllerImpl implements TeamsController {

    private List<Team> teamsList;
    private MembersController membersController;

    public TeamsControllerImpl( MembersController membersController) {
        this.membersController = membersController;
        teamsList = new ArrayList<>();

    }

    @Override
    public void updateTeamsData(List<Team> teamsData) {
        teamsList.clear();
        teamsList.addAll(teamsData);
    }

    @Override
    public void addNewTeam(Team team) {
        Validator.validateArgumentIsNotNull(team, "Team can't be null");
        Validator.checkForExistingValue(teamsList, team, "This Team already exists");
        this.teamsList.add(team);
    }

    @Override
    public List<Team> getAllTeams() {
        return new ArrayList<>(teamsList);
    }

    @Override
    public String showTeamActivity(String teamName) {
        return getTeam(teamName).teamActivity();
    }

    @Override
    public String showTeamMebers(String teamName) {
        return getTeam(teamName).showTeamMembers();
    }

    @Override
    public String showTeamBoards(String teamName) {
        return getTeam(teamName).showTeamBoards();
    }

    @Override
    public String showBoardsActivity(String teamName, String boardName) {
        return getTeam(teamName).getThisBoardFromTeam(boardName).showActivity();
    }

    @Override
    public String showBoardsContent(String teamName, String boardName) {
        return getTeam(teamName).getThisBoardFromTeam(boardName).showWorkItems();
    }

    @Override
    public void assignBoardToTeam(Board boardToAssign, String teamName) {
        getTeam(teamName).addBoardToTeam(boardToAssign);
    }

    @Override
    public void assignTeamMemberToTeam(String targetedTeamName, String teamMemberName) {
         getTeam(targetedTeamName).addMemberToTeam(membersController.getMember(teamMemberName));
    }

    @Override
    public void createWorkItemInBoard(String teamName, String boardName, WorkingItems item) {
        getTeam(teamName).getThisBoardFromTeam(boardName).addWorkItem(item);
    }

    private Team getTeam(String name) {
        Validator.validateArgumentIsNotNull(name, "name can't be null");
        Optional<Team> matchingTeam = teamsList.stream()
                .filter(team -> team.getName().toLowerCase().equals(name.toLowerCase()))
                .findFirst();

        return matchingTeam.orElseThrow(() -> new IllegalArgumentException("No such team found"));
    }
}
