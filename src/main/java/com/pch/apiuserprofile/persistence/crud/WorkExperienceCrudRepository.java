package com.pch.apiuserprofile.persistence.crud;

import com.pch.apiuserprofile.persistence.models.WorkExperienceDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WorkExperienceCrudRepository extends CrudRepository<WorkExperienceDAO, Integer> {
    List<WorkExperienceDAO> findByIdUserProfile(int idUserProfile);
}
