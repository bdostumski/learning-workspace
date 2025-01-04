package com.telerikacademy.wim.models;

import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeamImpl implements Team, Serializable {

    private String name;
    private List<Member> members;
    private List<Board> boards;
    private List<String> teams;

    public TeamImpl(String name) {
        setName(name);
        members = new ArrayList<>();
        boards = new ArrayList<>();
        teams = new ArrayList<>();
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        Validator.validateArgumentIsNotNull(name, "Team name can't be null");
        Validator.validateIntRange(name.length(), 5, 10, "Team name should be between 5 & 10 chars");
        this.name = name;
    }

    @Override
    public List<Member> getTeamMembers() {
        return new ArrayList<>(members);
    }

    @Override
    public List<Board> getTeamBoards() {
        return new ArrayList<>(boards);
    }

    @Override
    public void addMemberToTeam(Member member) {
        Validator.validateArgumentIsNotNull(member, "There is no such registered member");
        if (!members.contains(member)) {
            members.add(member);
            teams.add(String.format("Added member %s to the team %s.", member.getName(), getName()));
        } else {
            throw new IllegalArgumentException("This team member is already assigned to this team");
        }
    }

    @Override
    public void removeMemberFromTeam(Member member) {
        Validator.validateArgumentIsNotNull(member, "There is no such registered member");
        if (members.contains(member)) {
            members.remove(member);
            teams.add(String.format("Removed member %s from the team %s.", member.getName(), getName()));

        } else {
            throw new IllegalArgumentException("There is no such member in this team");
        }
    }

    @Override
    public void addBoardToTeam(Board board) {
        Validator.validateArgumentIsNotNull(board, "Board can't be null");
        if (!boards.contains(board)) {
            boards.add(board);
            teams.add(String.format("Added board %s to the team %s.", board.getName(), getName()));
        } else {
            throw new IllegalArgumentException("The team already has such board");
        }
    }

    @Override
    public void removeBoardFromTeam(Board board) {
        Validator.validateArgumentIsNotNull(board, "Board can't be null");
        if (boards.contains(board)) {
            boards.remove(board);
            teams.add(String.format("Removed board %s from the team %s.", board.getName(), getName()));
        } else {
            throw new IllegalArgumentException("No such board was found in this team");
        }
    }

    public Board getThisBoardFromTeam(String boardName) {
        Optional<Board> matchingBoard = boards.stream().
                filter(board -> board.getName().toLowerCase().equals(boardName.toLowerCase())).
                findFirst();

        return matchingBoard.orElseThrow(() -> new IllegalArgumentException("No such board found"));
    }

    @Override
    public String showTeamMembers() {
        String result = "Team Members" + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("For team: ").append(getName()).append("\n");
        int index = 1;
        for (Member member : members) {
            sb.append(index++).append(". ").append("Team Member: ").append(member.getName()).append("\n");
        }
        result = sb.toString();
        return result;
    }

    @Override
    public String showTeamBoards() {
        String result = "Team Boards " + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("For team: ").append(getName()).append("\n");
        int index = 1;
        for (Board board : boards) {
            sb.append(index++).append(". ").append("Team Board: ").append(board.getName()).append("\n");
        }
        result = sb.toString();
        return result;
    }

    public String teamActivity(){
        String result = "Team Activity " + "\n";
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("Team: ").append(getName()).append(" has been doing : ").append("\n");
        int index = 1;
        for (String team : teams) {
            sb.append(index++).append(". ").append(team).append("\n");
        }
        result = sb.toString();
        return result;

    }
}


