package gui.components;

import com.telerikacademy.wim.commands.ExitCommand;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.factories.CommandExecutor;
import gui.commands.*;
import gui.components.contracts.MainMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static gui.common.ConstantsGui.*;


public class MainMenuImpl implements MainMenu, ActionListener {

    private static JMenuBar menuBar;
    private WorkItemsController workItemsController;
    private TeamsController teamsController;
    private MembersController membersController;
    private ExitCommand exitCommand;



    public JMenuBar getMenuBar() {
        return menuBar;
    }

    private static JMenu fileMenu;
    private static JMenu createMenu;
    private static JMenu addMenu;
    private static JMenu assignMenu;
    private static JMenu unassignMenu;
    private static JMenu changeMenu;
    private static JMenu showMenu;
    private static JMenu sortMenu;


    private static JMenuItem exit; // openFile, closeFile,
    private static JMenuItem createMember, createTeam, createNewBoard, createBug, createFeedBack, createStory;
    private static JMenuItem addCommentToWorkItem;
    private static JMenuItem assignMemberToTeam, assignWorkToMember;
    private static JMenuItem unassignWorkToMember;
    private static JMenuItem changeBugPriority, changeBugSeverity, changeBugStatus, changeFeedBackRating, changeFeedBackStatus,
            changeStoryPriority, changeStorySize, changeStoryStatus;
    private static JMenuItem showAllMembers, showAllTeams, listAllWorkItems, listBugsOnly, listFeedBacksOnly, listStoriesOnly,
            showTeamsBoards, showBoardActivity, showMemberActivity, showTeamActivity;
    private static JMenuItem sortBySeverity, sortByPriority, sortByRating, sortByTitle, sortBySize;

    public MainMenuImpl(WorkItemsController workItemsController,
                        TeamsController teamsController,
                        MembersController membersController,
                        ExitCommand exitCommand) {

        this.workItemsController = workItemsController;
        this.teamsController = teamsController;
        this.membersController = membersController;
        this.exitCommand = exitCommand;

        menuBar = new JMenuBar();

        fileMenu = new JMenu(FILE);
//        openFile = new JMenuItem(OPEN);
//        closeFile = new JMenuItem(CLOSE);
        exit = new JMenuItem(EXIT);
//        fileMenu.add(openFile);
//        fileMenu.add(closeFile);
        fileMenu.add(exit);

        createMenu = new JMenu(CREATE);
        createMember = new JMenuItem(CREATE_MEMBER);
        createTeam = new JMenuItem(CREATE_TEAM);
        createNewBoard = new JMenuItem(CREATE_BOARD);
        createBug = new JMenuItem(CREATE_BUG);
        createFeedBack = new JMenuItem(CREATE_FEED_BACK);
        createStory = new JMenuItem(CREATE_STORY);
        createMenu.add(createMember);
        createMenu.add(createTeam);
        createMenu.add(createNewBoard);
        createMenu.add(createBug);
        createMenu.add(createFeedBack);
        createMenu.add(createStory);

        addMenu = new JMenu(ADD);
        addCommentToWorkItem = new JMenuItem(ADD_COMMENT_TO_ITEM);
        addMenu.add(addCommentToWorkItem);

        assignMenu = new JMenu(ASSIGN);
        assignMemberToTeam = new JMenuItem(ASSIGN_MEMBER_TO_TEAM);
        assignWorkToMember = new JMenuItem(ASSIGN_ITEM_TO_MEMBER);
        assignMenu.add(assignMemberToTeam);
        assignMenu.add(assignWorkToMember);

        unassignMenu = new JMenu(UNASSIGN);
        unassignWorkToMember = new JMenuItem(UNASSIGN_WORK_TO_MEMBER);
        unassignMenu.add(unassignWorkToMember);

        changeMenu = new JMenu(CHANGE);
        changeBugPriority = new JMenuItem(CHANGE_BUG_PRIORITY);
        changeBugSeverity = new JMenuItem(CHANGE_BUG_SEVERITY);
        changeBugStatus = new JMenuItem(CHANGE_BUG_STATUS);
        changeFeedBackRating = new JMenuItem(CHANGE_FEED_BACK_RATING);
        changeFeedBackStatus = new JMenuItem(CHANGE_FEED_BACK_STATUS);
        changeStoryPriority = new JMenuItem(CHANGE_STORY_PRIORITY);
        changeStorySize = new JMenuItem(CHANGE_STORY_SIZE);
        changeStoryStatus = new JMenuItem(CHANGE_STORY_STATUS);
        changeMenu.add(changeBugPriority);
        changeMenu.add(changeBugSeverity);
        changeMenu.add(changeBugStatus);
        changeMenu.add(changeFeedBackRating);
        changeMenu.add(changeFeedBackStatus);
        changeMenu.add(changeStoryPriority);
        changeMenu.add(changeStorySize);
        changeMenu.add(changeStoryStatus);

        showMenu = new JMenu(SHOW);
        showAllMembers = new JMenuItem(SHOW_ALL_MEMBERS);
        showAllTeams = new JMenuItem(SHOW_ALL_TEAMS);
        listAllWorkItems = new JMenuItem(SHOW_ALL_ITEMS);
        listBugsOnly = new JMenuItem(SHOW_BUGS_ONLY);
        listFeedBacksOnly = new JMenuItem(SHOW_FEED_BACK_ONLY);
        listStoriesOnly = new JMenuItem(SHOW_STORIES_ONLY);
        showTeamsBoards = new JMenuItem(SHOW_ALL_TEAMS_BOARDS);
        showBoardActivity = new JMenuItem(SHOW_BOARD_ACTIVITY);
        showMemberActivity = new JMenuItem(SHOW_MEMBER_ACTIVITY);
        showTeamActivity = new JMenuItem(SHOW_TEAM_ACTIVITY);
        showMenu.add(showAllMembers);
        showMenu.add(showAllTeams);
        showMenu.add(listAllWorkItems);
        showMenu.add(listBugsOnly);
        showMenu.add(listFeedBacksOnly);
        showMenu.add(listStoriesOnly);
        showMenu.add(showTeamsBoards);
        showMenu.add(showBoardActivity);
        showMenu.add(showMemberActivity);
        showMenu.add(showTeamActivity);

        sortMenu = new JMenu(SORT);
        sortBySeverity = new JMenuItem(SORT_BY_SEVERITY);
        sortByPriority = new JMenuItem(SORT_BY_PRIORITY);
        sortByRating = new JMenuItem(SORT_BY_RATING);
        sortByTitle = new JMenuItem(SORT_BY_TITLE);
        sortBySize = new JMenuItem(SORT_BY_SIZE);
        sortMenu.add(sortBySeverity);
        sortMenu.add(sortByPriority);
        sortMenu.add(sortByRating);
        sortMenu.add(sortByTitle);
        sortMenu.add(sortBySize);

        menuBar.add(fileMenu);
        menuBar.add(createMenu);
        menuBar.add(addMenu);
        menuBar.add(assignMenu);
        menuBar.add(unassignMenu);
        menuBar.add(changeMenu);
        menuBar.add(showMenu);
        menuBar.add(sortMenu);

//        openFile.addActionListener(this);
//        closeFile.addActionListener(this);
        exit.addActionListener(this);

        createMember.addActionListener(this);
        createMember.addActionListener(this);
        createTeam.addActionListener(this);
        createNewBoard.addActionListener(this);
        createBug.addActionListener(this);
        createFeedBack.addActionListener(this);
        createStory.addActionListener(this);

        addCommentToWorkItem.addActionListener(this);

        assignMemberToTeam.addActionListener(this);
        assignWorkToMember.addActionListener(this);

        unassignWorkToMember.addActionListener(this);

        changeBugPriority.addActionListener(this);
        changeBugSeverity.addActionListener(this);
        changeBugStatus.addActionListener(this);
        changeFeedBackRating.addActionListener(this);
        changeFeedBackStatus.addActionListener(this);
        changeStoryPriority.addActionListener(this);
        changeStorySize.addActionListener(this);
        changeStoryStatus.addActionListener(this);

        showAllMembers.addActionListener(this);
        showAllTeams.addActionListener(this);
        listAllWorkItems.addActionListener(this);
        listBugsOnly.addActionListener(this);
        listFeedBacksOnly.addActionListener(this);
        listStoriesOnly.addActionListener(this);
        showTeamsBoards.addActionListener(this);
        showBoardActivity.addActionListener(this);
        showMemberActivity.addActionListener(this);
        showTeamActivity.addActionListener(this);

        sortBySeverity.addActionListener(this);
        sortByPriority.addActionListener(this);
        sortByRating.addActionListener(this);
        sortByTitle.addActionListener(this);
        sortBySize.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String choice = event.getActionCommand();

        switch (choice) {
//            case OPEN: {
//                getLabel().setText(OPEN_FILE);
//            }
//            break;
//            case CLOSE: {
//                getLabel().setText(CLOSE_FILE);
//            }
//            break;
            case EXIT: {
                try {
                    exitCommand.execute();
                }catch (IOException e){

                }
            }
            break;
            case CREATE_MEMBER: {
                new CreateMemberGui(membersController);
            }
            break;
            case CREATE_TEAM: {
                new CreateTeamGui(teamsController);
            }
            break;
            case CREATE_BOARD: {
                new CreateNewBoardGui(teamsController); }
            break;
            case CREATE_BUG: {
                new CreateBugGui(teamsController, workItemsController);
            }
            break;
            case CREATE_FEED_BACK: {
                new CreateFeedBackGui(teamsController, workItemsController);
            }
            break;
            case CREATE_STORY: {
                new CreateStoryGui(teamsController, workItemsController);
            }
            break;
            case ADD_COMMENT_TO_ITEM: {
                new AddCommentToWorkItemGui(workItemsController);
            }
            break;
            case ASSIGN_MEMBER_TO_TEAM: {
                new AssignMemberToTeamGui(teamsController);
            }
            break;
            case ASSIGN_ITEM_TO_MEMBER: {
                new AssignWorkToMemberGui(membersController);
            }
            break;
            case UNASSIGN_WORK_TO_MEMBER: {
                new UnassignItemToMemberGui(membersController);
            }
            break;
            case CHANGE_BUG_PRIORITY: {
                new ChangeBugPriorityGui(workItemsController);
            }
            break;
            case CHANGE_BUG_SEVERITY: {
                new ChangeBugSeverityGui(workItemsController);
            }
            break;
            case CHANGE_BUG_STATUS: {
                new ChangeBugStatusGui(workItemsController);
            }
            break;
            case CHANGE_FEED_BACK_RATING: {
                new ChangeFeedBackRatingGui(workItemsController);
            }
            break;
            case CHANGE_FEED_BACK_STATUS: {
                new ChangeFeedBackStatusGui(workItemsController);
            }
            break;
            case CHANGE_STORY_PRIORITY: {
                new ChangeStoryPriorityGui(workItemsController);
            }
            break;
            case CHANGE_STORY_SIZE: {
                new ChangeStorySizeGui(workItemsController);
            }
            break;
            case CHANGE_STORY_STATUS: {
                new ChangeStoryStatusGui(workItemsController);
            }
            break;
            case SHOW_ALL_MEMBERS: {
                new ExecuteWindow(showMembers());
            }
            break;
            case SHOW_ALL_TEAMS: {
                new ExecuteWindow(showTeams()); }
            break;
            case SHOW_ALL_ITEMS: {
                new ExecuteWindow(showAllItems());
            }
            break;
            case SHOW_BUGS_ONLY: {
                new ExecuteWindow(showBug());
            }
            break;
            case SHOW_FEED_BACK_ONLY: {
                new ExecuteWindow(showFeedBacks());
            }
            break;
            case SHOW_STORIES_ONLY: {
                new ExecuteWindow(showStoriesOnly());
            }
            break;
            case SHOW_ALL_TEAMS_BOARDS: {
                new ShowTeamsBoardsGui(teamsController);
            }
            break;
            case SHOW_BOARD_ACTIVITY: {
                new ShowBoardActivityGui(teamsController);
            }
            break;
            case SHOW_MEMBER_ACTIVITY: {
                new ShowMemberActivityGui(membersController);
            }
            break;
            case SHOW_TEAM_ACTIVITY: {
                new ShowTeamActivityGui(teamsController);
            }
            break;
            case SORT_BY_SEVERITY: {
                new ExecuteWindow(sortBySeverity());
            }
            break;
            case SORT_BY_PRIORITY: {
                new ExecuteWindow(sortByPriority());
            }
            break;
            case SORT_BY_RATING: {
                new ExecuteWindow(sortByRating());
            }
            break;
            case SORT_BY_TITLE: {
                new ExecuteWindow(sortByTitle());
            }
            break;
            case SORT_BY_SIZE: {
                new ExecuteWindow(sortBySize());
            }
            break;
            default:
                new ExecuteWindow(WORK_ITEM_MANAGEMENT_WIM);

        }
    }

    private String showMembers() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.showAllMembers(membersController);
        return command.execute(list);
    }

    private String showTeams() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.showAllTeams(teamsController);
        return command.execute(list);
    }

    private String showBug() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.showBugsOnly(workItemsController);
        return command.execute(list);
    }

    private String showFeedBacks() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.showFeedbacksOnly(workItemsController);
        return command.execute(list);
    }

    private String showStoriesOnly() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.showStoriesOnly(workItemsController);
        return command.execute(list);
    }

    private String sortBySize() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.sortsBySize(workItemsController);
        return command.execute(list);
    }

    private String sortByTitle() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.sortsByTitle(workItemsController);
        return command.execute(list);
    }

    private String sortByRating() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.sortFeedbacksByRating(workItemsController);
        return command.execute(list);
    }

    private String sortByPriority() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.sortsByPriority(workItemsController);
        return command.execute(list);
    }

    private String sortBySeverity() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.sortBugsBySeverity(workItemsController);
        return command.execute(list);
    }

    private String showAllItems() {
        CommandExecutor executor = new CommandExecutor();

        Command command;
        List<String> list = new ArrayList<>();
        command = executor.showAllWorkingItems(workItemsController);
        return command.execute(list);
    }

}
