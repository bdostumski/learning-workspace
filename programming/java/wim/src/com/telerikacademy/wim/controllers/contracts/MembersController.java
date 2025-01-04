package com.telerikacademy.wim.controllers.contracts;

import com.telerikacademy.wim.models.contracts.Member;

import java.util.List;

public interface MembersController {

    void updateMembersData(List<Member> membersData);

    void addNewMember(Member member);

    Member getMember(String memberName);

    String showMemberActivity (String memberName);

    void assignWorkItemToMember (String memberName, int itemId);

    void unassignWorkItemToMember (String memberName, int itemId);

    List<Member> getAllMembers();
}
