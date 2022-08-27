package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.domain.gateways.WorkExperienceGateway;
import com.pch.apiuserprofile.persistence.crud.WorkExperienceCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.WorkExperienceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkExperienceRepository implements WorkExperienceGateway {

    private WorkExperienceCrudRepository crudRepository;

    private WorkExperienceMapper mapper;

    public WorkExperienceRepository(WorkExperienceCrudRepository crudRepository, WorkExperienceMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<WorkExperience> getAll() {
        return null;
    }

    @Override
    public Optional<List<WorkExperience>> getByUserProfile(int idUserProfile) {
        return Optional.empty();
    }

    @Override
    public Optional<WorkExperience> getWorkExperienceById(int id) {
        return Optional.empty();
    }

    @Override
    public WorkExperience saveWorkExperience(WorkExperience workExperience) {
        return null;
    }

    @Override
    public void deleteWorkExperienceById(int id) {

    }
}
