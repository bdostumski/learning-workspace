package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.models.contracts.Team;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class ShowAllTeams implements Command {

    private List<Team> teamsList;

    public ShowAllTeams(TeamsController controller) {
        teamsList = controller.getAllTeams();
    }

    @Override
    public String execute(List<String> parameters) {

        if (teamsList.size() == 0) {
            return "There are no registered teams yet.";


        }
        List<String> teamsList = teamsToString();

        return String.join(JOIN_DELIMITER + System.lineSeparator(), teamsList).trim();

    }

    private List<String> teamsToString() {
        List<String> stringifiedTeams = new ArrayList<>();
        for (Team team : teamsList) {
            stringifiedTeams.add(team.getName());
        }
        return stringifiedTeams;
    }


}
