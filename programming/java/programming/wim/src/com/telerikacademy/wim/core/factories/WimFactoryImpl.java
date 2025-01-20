package com.telerikacademy.wim.core.factories;

import com.telerikacademy.wim.core.contracts.WimFactory;
import com.telerikacademy.wim.models.BoardImpl;
import com.telerikacademy.wim.models.MemberImpl;
import com.telerikacademy.wim.models.TeamImpl;
import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SeverityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.contracts.Board;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.contracts.Team;
import com.telerikacademy.wim.models.items.BugImpl;
import com.telerikacademy.wim.models.items.FeedBackImpl;
import com.telerikacademy.wim.models.items.StoryImpl;
import com.telerikacademy.wim.models.items.WorkingItemsImpl;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;

public class WimFactoryImpl implements WimFactory {
    @Override
    public Team createNewTeam(String name) {
        return new TeamImpl(name);

    }

    @Override
    public Board createNewBoard(String name) {
        return new BoardImpl(name);

    }

    @Override
    public Member createNewMember(String name) {
        return new MemberImpl(name);
    }

    @Override
    public WorkingItems createNewBug(String title, String description, String priority, String severity) {
        return new BugImpl(title, description, PriorityType.valueOf(priority.toUpperCase()), SeverityType.valueOf(severity.toUpperCase()));

    }

    @Override
    public WorkingItems createNewStory(String title, String description, String priority, String size) {
        return new StoryImpl(title, description, PriorityType.valueOf(priority.toUpperCase()), SizeType.valueOf(size.toUpperCase()));
    }

    @Override
    public WorkingItems createNewFeedback(String title, String description, int rating) {
        return new FeedBackImpl(title, description, rating);
    }
}
