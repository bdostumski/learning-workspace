package com.telerikacademy.wim.commands.changes;

import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.items.contracts.Comment;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.models.items.CommentImpl;
import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.INVALID_NUMBER_OF_ARGUMENTS;

public class AddCommentToWorkItem implements Command {

    private static final int EXPECTED_NUMBER_OF_ARGUMENTS = 3;
    private  static final String FAILED_TO_PARSE_ADD_COMMENT_TO_WORK_ITEM_COMMAND_PARAMETERS = "Failed to parse Add Comment To WorkItem command parameters.";
    private static final String SUCCESSFULLY_ADDED_COMMENT_TO_WORK_ITEM = "successfully added comment to work item";

    private final WorkItemsController itemsController;
    private int workingItemId;
    private String message, author;


    public AddCommentToWorkItem(WorkItemsController controller) {
        itemsController = controller;
    }

    @Override
    public String execute(List<String> parameters) {
        validateInput(parameters);
        parseParameters(parameters);

        Comment comment = new CommentImpl(message, author);
        itemsController.addCommentToWorkItem(workingItemId, comment);
        return SUCCESSFULLY_ADDED_COMMENT_TO_WORK_ITEM;
    }

    private void validateInput(List<String> parameters) {
        if (parameters.size() != EXPECTED_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException(String.format(INVALID_NUMBER_OF_ARGUMENTS, EXPECTED_NUMBER_OF_ARGUMENTS, parameters.size()));
        }
    }

    private void parseParameters(List<String> parameters) {
        try {
            workingItemId = Integer.parseInt(parameters.get(0));
            message = parameters.get(1);
            author = parameters.get(2);
        } catch (Exception e) {
            throw new IllegalArgumentException(FAILED_TO_PARSE_ADD_COMMENT_TO_WORK_ITEM_COMMAND_PARAMETERS);
        }
    }
}
