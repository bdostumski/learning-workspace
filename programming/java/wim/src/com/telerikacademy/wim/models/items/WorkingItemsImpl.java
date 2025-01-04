package com.telerikacademy.wim.models.items;

import static com.telerikacademy.wim.models.common.Constants.*;
import static com.telerikacademy.wim.models.common.Validator.validateArgumentIsNotNull;
import static com.telerikacademy.wim.models.common.Validator.validateIntRange;

import com.telerikacademy.wim.models.common.enums.WorkingItemsType;
import com.telerikacademy.wim.models.items.contracts.WorkingItems;
import com.telerikacademy.wim.models.items.contracts.Comment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class WorkingItemsImpl implements WorkingItems, Serializable {

    private static int staticId = 1;

    private int id = 0;
    private String title;
    private String description;
    private List<Comment> comments;
    private List<String> history;
    private WorkingItemsType itemsType;


    public WorkingItemsImpl(String title, String description, WorkingItemsType type) {
        setTitle(title);
        setDescription(description);
        itemsType = type;
        comments = new ArrayList<>();
        history = new ArrayList<>();
        id += staticId++;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() { return description; }

    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    @Override
    public void addComments(Comment comment) {
        validateArgumentIsNotNull(comment, NULL_COMMENT_ERROR);
        comments.add(comment);
    }

    @Override
    public void removeComments(Comment comment) { comments.remove(comment); }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(history);
    }

    @Override
    public abstract String getStatusString();

    private void setTitle(String title) {
        validateArgumentIsNotNull(title, NULL_TITLE_ERROR);
        validateIntRange(title.length(), TITLE_MIN_LENGTH, TITLE_MAX_LENGTH, TITLE_ERROR);
        this.title = title;
    }

    private void setDescription(String description) {
        validateArgumentIsNotNull(description, NULL_DESCRIPTION_ERROR);
        validateIntRange(description.length(), DESCRIPTION_MIN_LENGTH,
                DESCRIPTION_MAX_LENGTH, DESCRIPTION_ERROR);
        this.description = description;
    }

    public WorkingItemsType getItemsType() {
        return itemsType;
    }

    @Override
    public String toString() {
        return String.format("--WORKING ITEMS--%n" +
                "Id: %d%n" +
                "Title: %s%n" +
                "Description: %s%n" +
                "%s",
                id, title, description, getCommentsPrintString());
    }

    private String getCommentsPrintString() {
        if(comments.size() == 0) {
            return String.format("");
        }

        StringBuilder result = new StringBuilder();
        result.append(String.format("Comments: %n"));
        for(Comment comment : comments) {
            result.append(String.format("   %s", comment));
        }
        return result.toString();
    }
}
