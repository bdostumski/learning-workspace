package com.telerikacademy.wim.core;

import com.telerikacademy.wim.commands.ExitCommand;
import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.MembersControllerImpl;
import com.telerikacademy.wim.controllers.TeamsControllerImpl;
import com.telerikacademy.wim.controllers.WorkItemsControllerImpl;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.TeamsController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.core.contracts.*;
import com.telerikacademy.wim.data.WimRepositoryImpl;
import com.telerikacademy.wim.core.factories.CommandFactoryImpl;
import com.telerikacademy.wim.core.factories.WimFactoryImpl;
import com.telerikacademy.wim.core.providers.CommandParserImpl;
import com.telerikacademy.wim.core.providers.ReaderImpl;
import com.telerikacademy.wim.core.providers.WriterImpl;
import gui.MainGui;

import java.util.List;

public class WimEngine implements Engine {

    private static final String TERMINATION_COMMAND = "Exit";
    private static final String REPORT_SEPARATOR = ">------------------------------------<";

    private WimFactory wimFactory;

    private Writer writer;
    private Reader reader;
    private CommandParser commandParser;
    private WimRepository wimRepository;
    private TeamsController teamsController;
    private MembersController membersController;
    private WorkItemsController workItemsController;
    private final CommandFactory commandFactory;
    private MainGui mainGui;
    ExitCommand exit;


    public WimEngine() {
        wimFactory = new WimFactoryImpl();
        writer = new WriterImpl();
        reader = new ReaderImpl();
        commandParser = new CommandParserImpl();
        wimRepository = new WimRepositoryImpl();
        commandFactory = new CommandFactoryImpl();
        workItemsController = new WorkItemsControllerImpl();
        membersController = new MembersControllerImpl(workItemsController);
        teamsController = new TeamsControllerImpl(membersController);
        exit = new ExitCommand(teamsController, membersController, workItemsController, wimRepository);
        mainGui = new MainGui(workItemsController, teamsController, membersController, exit);


    }


    public void start() {

        try {
            teamsController.updateTeamsData(wimRepository.getTeams());
            membersController.updateMembersData(wimRepository.getMembers());
            workItemsController.updateItemsData(wimRepository.getWorkingItems());
            workItemsController.updateBugsData(wimRepository.getBugsFromDB());
            workItemsController.updateStoryData(wimRepository.getStoriesFromDB());
            workItemsController.updateFeedbackData(wimRepository.getFeedbacksFromDB());

        } catch (Exception ex) {
            writer.writeLine(ex.getMessage() != null && !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString());
            writer.writeLine(REPORT_SEPARATOR);
        }


        while (true) {
            try {

                String commandAsString = reader.readLine();
                if (commandAsString.equalsIgnoreCase(TERMINATION_COMMAND)) {
                    exit.execute();
                    break;
                }
                processCommand(commandAsString);

            } catch (Exception ex) {
                writer.writeLine(ex.getMessage() != null && !ex.getMessage().isEmpty() ? ex.getMessage() : ex.toString());
                writer.writeLine(REPORT_SEPARATOR);
            }

        }
    }



    private void processCommand(String commandAsString) {
        if (commandAsString == null || commandAsString.trim().equals("")) {
            throw new IllegalArgumentException("Command cannot be null or empty.");
        }

        String commandTypeAsString = commandParser.parseCommand(commandAsString);
        Command command = commandFactory.createCommand(commandTypeAsString, wimFactory, membersController, teamsController, workItemsController);
        List<String> parameters = commandParser.parseParameters(commandAsString);
        String executionResult = command.execute(parameters);
        writer.writeLine(executionResult);
        writer.writeLine(REPORT_SEPARATOR);

    }
}