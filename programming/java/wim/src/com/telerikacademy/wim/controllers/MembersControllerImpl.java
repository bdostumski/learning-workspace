package com.telerikacademy.wim.controllers;

import com.telerikacademy.wim.controllers.contracts.MembersController;
import com.telerikacademy.wim.controllers.contracts.WorkItemsController;
import com.telerikacademy.wim.models.common.Validator;
import com.telerikacademy.wim.models.contracts.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MembersControllerImpl implements MembersController {

    private final List<Member> membersList;
    private  WorkItemsController itemsController;


    public MembersControllerImpl(WorkItemsController itemsController) {
        this.itemsController = itemsController;
        membersList = new ArrayList<>();

    }

    @Override
    public void updateMembersData(List<Member> membersData) {
        membersList.clear();
        membersList.addAll(membersData);
    }

    @Override
    public void addNewMember(Member member) {
        Validator.validateArgumentIsNotNull(member, "Member can't be null");
        Validator.checkForExistingValue(membersList, member, "This member already exists");
        this.membersList.add(member);

    }

    @Override
    public Member getMember(String memberName) {
        Validator.validateArgumentIsNotNull(memberName, "name can't be null");
        Optional<Member> matchingMember = membersList.stream()
                .filter(team -> team.getName().toLowerCase().equals(memberName.toLowerCase()))
                .findFirst();

        return matchingMember.orElseThrow(() -> new IllegalArgumentException("No such member found"));
    }

    @Override
    public String showMemberActivity(String memberName) {
        return getMember(memberName).showHistory();
    }


    @Override
    public void assignWorkItemToMember(String memberName, int itemId) {

        getMember(memberName).addWorkItem(itemsController.getWorkingItem(itemId));
        itemsController.setAsignee(itemsController.getWorkingItem(itemId), getMember(memberName));
    }

    @Override
    public void unassignWorkItemToMember(String memberName, int itemId) {

        getMember(memberName).removeWorkItem(itemsController.getWorkingItem(itemId));
        itemsController.removeAsignee(itemsController.getWorkingItem(itemId), getMember(memberName));
    }

    @Override
    public List<Member> getAllMembers() {
        return new ArrayList<>(membersList);
    }
}
