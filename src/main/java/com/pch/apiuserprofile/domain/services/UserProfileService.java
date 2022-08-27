package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.gateways.UserProfileGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileGateway gateway;

    public List<UserProfile> getAll(){
        return gateway.getAll();
    }

    public Optional<UserProfile> getUserById(int id){
        return gateway.getUserById(id);
    }

    public UserProfile saveUserProfile(UserProfile userProfile){
        return gateway.saveUserProfile(userProfile);
    }

    public boolean deleteUserById(int id){
        return getUserById(id).map(userProfile -> {
            gateway.deleteUserById(id);
            return true;
        }).orElse(false);
    }

}
