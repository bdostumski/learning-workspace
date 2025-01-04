package com.telerikacademy.wim.core.contracts;

import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface WimRepository {

    List<Team> getTeams() throws IOException, ClassNotFoundException;

    List<Member> getMembers()throws IOException, ClassNotFoundException;

    List<WorkingItems> getWorkingItems()throws IOException, ClassNotFoundException;

    void saveTeamsInfoToDatabase(List<Team> latestTeamsData)throws IOException;

    void saveMembersDataToDatabase(List<Member> latestMembersData)throws IOException;

    void saveWorkkingItemsDataToDatabase(List<WorkingItems> latestItemsData)throws IOException;

}
