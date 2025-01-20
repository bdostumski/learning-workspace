package com.telerikacademy.wim.core.data;

import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WimRepositoryImpl implements WimRepository {

    private  List<Team> teams = new ArrayList<>();
    private  List<Member> members = new ArrayList<>();
    private  List<WorkingItems> workItems = new ArrayList<>();

    public List<Team> getTeams() throws IOException, ClassNotFoundException {
        TeamsDataImpl teamsData = new TeamsDataImpl();
        teamsData.loadItemsFromDatabase(teams);
        return new ArrayList<>(teams);
    }

    public List<Member> getMembers() throws IOException, ClassNotFoundException {
        MembersDataImpl membersData = new MembersDataImpl();
        membersData.loadItemsFromDatabase(members);
        return new ArrayList<>(members);
    }

    public List<WorkingItems> getWorkingItems() throws IOException, ClassNotFoundException {
        ItemsDataImpl itemsData = new ItemsDataImpl();
        itemsData.loadItemsFromDatabase(workItems);
        return new ArrayList<>(workItems);
    }

    public void saveTeamsInfoToDatabase(List<Team> latestTeamsData) throws IOException {
        Validator.validateArgumentIsNotNull(latestTeamsData, "List of teams can't be null");
        TeamsDataImpl teamsData = new TeamsDataImpl();
        teamsData.saveItemsToDatabase(latestTeamsData);
    }

    public void saveMembersDataToDatabase(List<Member> latestMembersData) throws IOException {
        Validator.validateArgumentIsNotNull(latestMembersData, "List of members can't be null");
        MembersDataImpl membersData = new MembersDataImpl();
        membersData.saveItemsToDatabase(latestMembersData);
    }

    public void saveWorkkingItemsDataToDatabase(List<WorkingItems> latestItemsData) throws IOException {
        Validator.validateArgumentIsNotNull(latestItemsData, "List of items can't be null");
        ItemsDataImpl itemsData = new ItemsDataImpl();
        itemsData.saveItemsToDatabase(latestItemsData);
    }

    //TODO - handle EOFException

}
