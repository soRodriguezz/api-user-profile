package com.pch.apiuserprofile.domain.gateways;

import com.pch.apiuserprofile.domain.entities.UserProfile;

import java.util.List;
import java.util.Optional;


public interface UserProfileGateway {

    List<UserProfile> getAll();

    Optional<UserProfile> getUserById(int id);

    UserProfile saveUserProfile(UserProfile userProfile);

    void deleteUserById(int id);
}
