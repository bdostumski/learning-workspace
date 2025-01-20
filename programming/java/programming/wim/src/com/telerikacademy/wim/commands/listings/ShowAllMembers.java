package com.telerikacademy.wim.commands.listings;

import com.telerikacademy.wim.commands.contracts.Command;
import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.core.contracts.WimRepository;
import com.telerikacademy.wim.models.contracts.Member;

import java.util.ArrayList;
import java.util.List;

import static com.telerikacademy.wim.commands.ComandsConstants.JOIN_DELIMITER;

public class ShowAllMembers implements Command {

    private List<Member> membersList;

    public ShowAllMembers(MembersController controller) {
        membersList = controller.getAllMembers();
    }

    @Override
    public String execute(List<String> parameters) {

        if (membersList.size() == 0) {
            return "There are no registered members yet.";
        }
        List<String> membersList = membersToString();

        return String.join(JOIN_DELIMITER + System.lineSeparator(), membersList).trim();

    }

    private List<String> membersToString() {
        List<String> stringifiedMembers = new ArrayList<>();
        for (Member member : membersList) {
            stringifiedMembers.add(member.getName());
        }
        return stringifiedMembers;
    }
}
