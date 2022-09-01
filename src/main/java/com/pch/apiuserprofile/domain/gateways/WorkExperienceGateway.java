package com.pch.apiuserprofile.domain.gateways;

import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.entities.WorkExperience;

import java.util.List;
import java.util.Optional;


public interface WorkExperienceGateway {

    List<WorkExperience> getAll();

    Optional<List<WorkExperience>> getByIdUserProfile(int idUserProfile);

    Optional<WorkExperience> getWorkExperienceById(int id);

    WorkExperience saveWorkExperience(WorkExperience workExperience);

    WorkExperience updateWorkExperience(WorkExperience workExperience);

    void deleteWorkExperienceById(int id);
}
