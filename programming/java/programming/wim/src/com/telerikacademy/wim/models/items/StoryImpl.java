package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.common.enums.PriorityType;
import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.common.enums.StoryStatusType;
import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.contracts.Member;
import com.telerikacademy.wim.models.items.contracts.Story;

import java.io.Serializable;

public class StoryImpl extends CommonDetailsImpl implements Story, Serializable {

    private SizeType sizeType;
    private StoryStatusType storyStatusType;

    public StoryImpl(String title,
                     String description,
                     PriorityType priority,
                     SizeType sizeType) {
        super(title, description, priority, WorkingItemsType.STORY);
        this.sizeType = sizeType;
        this.storyStatusType = StoryStatusType.NOTDONE;
    }

    @Override
    public SizeType getStorySizeType() {
        return sizeType;
    }

    @Override
    public void changeStorySizeType(SizeType sizeType) { this.sizeType = sizeType; }

    @Override
    public StoryStatusType getStoryStatusType() {
        return storyStatusType;
    }

    @Override
    public void changeStoryStatusType(StoryStatusType storyStatusType) { this.storyStatusType = storyStatusType; }

    @Override
    public void changeAssignee(Member assignee) { super.changeAssignee(assignee); }

    @Override
    public Member getAssignee() { return super.getAssignee(); }

    @Override
    public String getStatusString() {
        return storyStatusType.toString();
    }

    @Override
    public String toString() {
        return String.format("%s" +
                "Size: %s%n" +
                "Status: %s%n",
                super.toString(), sizeType, storyStatusType);
    }
}
