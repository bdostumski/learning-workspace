package com.syscomz.springreactaws.profile;

import com.syscomz.springreactaws.datastore.FakeUserRoleFileDataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserProfileDataAccessService {

    private final FakeUserRoleFileDataStore fakeUserProfileDataStore;

    @Autowired
    public UserProfileDataAccessService(FakeUserRoleFileDataStore fakeUserProfileDataStore) {
        this.fakeUserProfileDataStore = fakeUserProfileDataStore;
    }

    List<UserProfile> getUserProfiles() {
        return fakeUserProfileDataStore.getUserProfiles();
    }
}