package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.gateways.UserProfileGateway;
import com.pch.apiuserprofile.persistence.crud.UserProfileCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.UserProfileMapper;
import com.pch.apiuserprofile.persistence.models.UserProfileDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserProfileRepository implements UserProfileGateway {

    private UserProfileCrudRepository crudRepository;

    private UserProfileMapper mapper;

    public UserProfileRepository(UserProfileCrudRepository crudRepository, UserProfileMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UserProfile> getAll() {
        List<UserProfileDAO> daos = (List<UserProfileDAO>) crudRepository.findAll();
        return mapper.toUserProfiles(daos);
    }

    @Override
    public Optional<UserProfile> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        UserProfileDAO userProfileDAO = crudRepository.save(mapper.toUserProfileDAO(userProfile));
        return mapper.toUserProfile(userProfileDAO);
    }

    @Override
    public void deleteUserById(int id) {

    }
}
