package com.telerikacademy.wim.models.items.contracts;

import com.telerikacademy.wim.models.common.enums.SizeType;
import com.telerikacademy.wim.models.common.enums.StoryStatusType;
import com.telerikacademy.wim.models.items.contracts.CommonDetails;

import java.io.Serializable;

public interface Story extends CommonDetails, Serializable {

    SizeType getStorySizeType();

    void changeStorySizeType(SizeType sizeType);

    StoryStatusType getStoryStatusType();

    void changeStoryStatusType(StoryStatusType storyStatusType);

}
