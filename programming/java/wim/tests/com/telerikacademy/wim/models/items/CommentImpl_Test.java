package com.telerikacademy.wim.models.items;

import com.telerikacademy.wim.models.items.contracts.Comment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CommentImpl_Test {

    @Test
    public void CommentImpl_ShouldImplementCommentInterface() {
        CommentImpl comment = new CommentImpl("content", "author");
        Assertions.assertTrue(comment instanceof Comment);
    }

    @Test
    public void Constructor_ShouldThrow_WhenMessageIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CommentImpl(null, "author"));
    }

    @Test
    public void Constructor_ShouldThrow_WhenAuthorIsNull() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new CommentImpl("message", null));
    }

    @Test
    public void Method_getMessage_ShouldPrintMessage() {
        CommentImpl comment = new CommentImpl("some message", "author");
        Assertions.assertEquals("some message", comment.getMessages());
    }

    @Test
    public void Method_getAuthor_ShouldCheckAuthorPrint() {
        CommentImpl comment = new CommentImpl("some message", "author");
        Assertions.assertEquals("author", comment.getAuthor());
    }

}
