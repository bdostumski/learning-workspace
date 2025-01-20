package com.telerikacademy.wim;

import com.telerikacademy.wim.core.WimEngine;
import com.telerikacademy.wim.core.contracts.Engine;

import java.io.ByteArrayInputStream;

public class Start {

    public static void main(String[] args) {

        fakeInput();

        Engine engine = new WimEngine();
        engine.start();

    }

    public static void fakeInput() {
        String test = "CREATETEAMMEMBER Member1\n" +
                "CREATETEAMMEMBER Member2\n" +
                "SHOWALLMEMBERS\n" +
                "CREATETEAM Team1\n" +
                "CREATETEAM Team2\n" +
                "SHOWALLTEAMS\n" +
                "CREATENEWBOARD Board1 Team1\n" +
                "CREATENEWBOARD Board2 Team2\n" +
                "SHOWTEAMSBOARDS Team1\n" +
                "SHOWTEAMSBOARDS Team2\n" +
                "ASSIGNMEMBERTOTEAM Team1 Member1\n" +
                "ASSIGNMEMBERTOTEAM Team2 Member2\n" +
                "CREATEBUG Team1 Board1 BugTitleBetween-10-50-Signs BugDescriptionBetween-10-500-Signs HIGH CRITICAL\n" +
                "CREATEBUG Team2 Board2 NewBugTitleBetween-10-50-Signs NewBugDescriptionBetween-10-500-Signs HIGH CRITICAL\n" +
                "LISTBUGSONLY\n" +
                "CHANGEBUGPRIORITY 1 MEDIUM\n" +
                "CHANGEBUGSEVERITY 1 MAJOR\n" +
                "CHANGEBUGSTATUS 1 FIXED\n" +
                "LISTBUGSONLY\n" +
                "CREATEFEEDBACK Team1 Board1 FeedBackTitleBetween-10-50-Signs FeedBackDescriptionBetween-10-500-Signs 1\n" +
                "CREATEFEEDBACK Team2 Board2 NewFeedBackTitleBetween-10-50-Signs NewFeedBackDescriptionBetween-10-500-Signs 1\n" +
                "LISTFEEDBACKSONLY\n" +
                "CHANGEFEEDBACKRATING 3 5\n" +
                "CHANGEFEEDBACKSTATUS 3 DONE\n" +
                "LISTFEEDBACKSONLY\n" +
                "CREATESTORY Team1 Board1 StoryTitleBetween-10-50-Signs StoryDescripitonBetween-10-500-Signs HIGH LARGE\n" +
                "CREATESTORY Team2 Board2 NewStoryTitleBetween-10-50-Signs NewStoryDescripitonBetween-10-500-Signs HIGH LARGE\n" +
                "LISTSTORIESONLY\n" +
                "CHANGESTORYPRIORITY 5 LOW\n" +
                "CHANGESTORYSIZE 5 SMALL\n" +
                "CHANGESTORYSTATUS 5 INPROGRESS\n" +
                "LISTSTORIESONLY\n" +
                "ADDCOMMENTTOWORKITEM 1 Message1 Author1\n" +
                "ADDCOMMENTTOWORKITEM 1 Message2 Author2\n" +
                "ADDCOMMENTTOWORKITEM 2 Message4 Author4\n" +
                "ADDCOMMENTTOWORKITEM 3 Message5 Author5\n" +
                "ASSIGNWORKTOMEMBER Member1 1\n" +
                "ASSIGNWORKTOMEMBER Member2 2\n" +
                "UNASSIGNWORKTOMEMBER Member1 1\n" +
                "UNASSIGNWORKTOMEMBER Member2 2\n" +
                "ASSIGNWORKTOMEMBER Member1 1\n" +
                "SHOWMEMBERACTIVITY Member1\n" +
                "SHOWMEMBERACTIVITY Member2\n" +
                "SHOWTEAMACTIVITY Team1\n" +
                "SHOWTEAMACTIVITY Team2\n" +
                "SHOWBOARDACTIVITY Team1 Board1\n" +
                "SHOWBOARDACTIVITY Team2 Board2\n" +
                "LISTALLWORKITEMS\n" +
                "SORTBYSEVERITY\n" +
                "SORTBYPRIORITY\n" +
                "SORTBYRATING\n" +
                "SORTBYTITLE\n" +
                "SORTBYSIZE\n" +
                "EXIT\n";

        System.setIn(new ByteArrayInputStream(test.getBytes()));
    }

}
