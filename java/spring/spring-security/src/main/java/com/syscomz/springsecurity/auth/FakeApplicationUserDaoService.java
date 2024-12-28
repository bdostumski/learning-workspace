package com.syscomz.springsecurity.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.syscomz.springsecurity.security.ApplicationUserRole.*;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(

                // annaSmithUser
                new ApplicationUser(
                        ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("admin123"),
                        "admin",
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE
                ),
                // lindaUser
                new ApplicationUser(
                        ADMINTRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("admintrainee123"),
                        "admintrainee",
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE
                ),
                // tomUser
                new ApplicationUser(
                        STUDENT.getGrantedAuthorities(),
                        passwordEncoder.encode("bdostumski123"),
                        "bdostumsk",
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE,
                        Boolean.TRUE
                )
        );

        return applicationUsers;
    }

}
