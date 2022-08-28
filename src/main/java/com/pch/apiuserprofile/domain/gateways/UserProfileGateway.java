package com.pch.apiuserprofile.domain.gateways;

import com.pch.apiuserprofile.domain.entities.UserProfile;

import java.util.List;
import java.util.Optional;


public interface UserProfileGateway {

    List<UserProfile> getAll();

    Optional<UserProfile> getUserProfileById(int id);

    UserProfile saveUserProfile(UserProfile userProfile);

    UserProfile updateUserProfile(UserProfile userProfile);

    void deleteUserProfileById(int id);
}
