package com.telerikacademy.wim.core.contracts;

import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

public interface WimFactory {

    Team createNewTeam(String name);

    Board createNewBoard(String name);

    Member createNewMember(String name);

    WorkingItems createNewBug(String title, String description, String priority, String severity);

    WorkingItems createNewStory (String title, String description, String priority, String size);

    WorkingItems createNewFeedback(String title, String description, int rating);
}
