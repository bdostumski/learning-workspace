package com.telerikacademy.wim.models.items.contracts;

import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.Comment;

import java.io.Serializable;
import java.util.List;

public interface WorkingItems extends Serializable {

    int getId();

    String getTitle();

    String getDescription();

    List<Comment> getComments();

    void addComments(Comment comment);

    void removeComments(Comment comment);

    WorkingItemsType getItemsType();

    List<String> getHistory();

    String getStatusString();

}
