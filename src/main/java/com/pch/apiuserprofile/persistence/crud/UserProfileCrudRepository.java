package com.pch.apiuserprofile.persistence.crud;

import com.pch.apiuserprofile.persistence.models.UserProfileDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface UserProfileCrudRepository extends CrudRepository<UserProfileDAO, Integer> {

    List<UserProfileDAO> findByChangeResidenceTrue();
    List<UserProfileDAO> findByDescriptionTechnologiesContaining(String technology);

    List<UserProfileDAO> findByAddressContaining(String cityCountry);

    List<UserProfileDAO> findByExperienceYearsGreaterThan(int experience);

    List<UserProfileDAO> findByAcademicBackgroundDegreeAndAcademicBackgroundCurrentlyStudyingTrue(String degree);

}
