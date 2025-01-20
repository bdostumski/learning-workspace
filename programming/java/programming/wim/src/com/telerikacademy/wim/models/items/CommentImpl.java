package com.telerikacademy.wim.models.items;

import static com.telerikacademy.wim.models.common.Constants.NULL_AUTHOR_ERROR;
import static com.telerikacademy.wim.models.common.Constants.NULL_MESSAGE_ERROR;
import static com.telerikacademy.wim.models.common.Validator.validateArgumentIsNotNull;
import com.telerikacademy.wim.models.items.contracts.Comment;

import java.io.Serializable;

public class CommentImpl implements Comment, Serializable {

    private String message;
    private String author;

    public CommentImpl(String message, String author) {
        setMessage(message);
        setAuthor(author);
    }

    @Override
    public String getMessages() {
        return message;
    }

    @Override
    public String getAuthor() {
        return author;
    }

    private void setMessage(String message) {
        validateArgumentIsNotNull(message, NULL_MESSAGE_ERROR);
        this.message = message;
    }

    private void setAuthor(String author) {
        validateArgumentIsNotNull(author, NULL_AUTHOR_ERROR);
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Message from %s -> %s%n", author, message);
    }

}
