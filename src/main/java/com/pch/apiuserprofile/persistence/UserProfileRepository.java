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

    private final UserProfileCrudRepository crudRepository;

    private final UserProfileMapper mapper;

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
    public Optional<UserProfile> getUserProfileById(int id) {
        UserProfileDAO userProfileDAO = crudRepository.findById(id).get();
        return Optional.ofNullable(mapper.toUserProfile(userProfileDAO));
    }

    @Override
    public UserProfile saveUserProfile(UserProfile userProfile) {
        UserProfileDAO userProfileDAO = crudRepository.save(mapper.toUserProfileDAO(userProfile));
        return mapper.toUserProfile(userProfileDAO);
    }

    @Override
    public UserProfile updateUserProfile(UserProfile userProfile) {
        UserProfileDAO userProfileDAO = crudRepository.save(mapper.toUserProfileDAO(userProfile));
        return mapper.toUserProfile(userProfileDAO);
    }

    @Override
    public List<UserProfile> findByChangeResidenceTrue() {
        List<UserProfileDAO> userProfileDAO = crudRepository.findByChangeResidenceTrue();
        return mapper.toUserProfiles(userProfileDAO);
    }

    @Override
    public List<UserProfile> findByDescriptionTechnologiesContaining(String technology) {
        List<UserProfileDAO> userProfileDAO = crudRepository.findByDescriptionTechnologiesContaining(technology);
        return mapper.toUserProfiles(userProfileDAO);
    }

    @Override
    public List<UserProfile> findByAddressContaining(String cityCountry) {
        List<UserProfileDAO> userProfileDAO = crudRepository.findByAddressContaining(cityCountry);
        return mapper.toUserProfiles(userProfileDAO);
    }

    @Override
    public List<UserProfile> findByExperienceYearsGreaterThan(int experience) {
        List<UserProfileDAO> userProfileDAO = crudRepository.findByExperienceYearsGreaterThan(experience);
        return mapper.toUserProfiles(userProfileDAO);
    }

    @Override
    public List<UserProfile> findByAcademicBackgroundDegreeAndAcademicBackgroundCurrentlyStudyingTrue(String degree) {
        List<UserProfileDAO> userProfileDAO = crudRepository.findByAcademicBackgroundDegreeAndAcademicBackgroundCurrentlyStudyingTrue(degree);
        return mapper.toUserProfiles(userProfileDAO);
    }

    @Override
    public void deleteUserProfileById(int id) {
        crudRepository.deleteById(id);
    }
}
