package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.domain.gateways.WorkExperienceGateway;
import com.pch.apiuserprofile.persistence.crud.WorkExperienceCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.WorkExperienceMapper;
import com.pch.apiuserprofile.persistence.models.AcademicBackgroundDAO;
import com.pch.apiuserprofile.persistence.models.WorkExperienceDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class WorkExperienceRepository implements WorkExperienceGateway {

    private final WorkExperienceCrudRepository crudRepository;

    private final WorkExperienceMapper mapper;

    public WorkExperienceRepository(WorkExperienceCrudRepository crudRepository, WorkExperienceMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<WorkExperience> getAll() {
        List<WorkExperienceDAO> daos = (List<WorkExperienceDAO>) crudRepository.findAll();
        return mapper.toWorkExperiences(daos);
    }

    @Override
    public Optional<List<WorkExperience>> getByIdUserProfile(int idUserProfile) {
        List<WorkExperienceDAO> daos = crudRepository.findByIdUserProfile(idUserProfile);
        return Optional.ofNullable(mapper.toWorkExperiences(daos));
    }

    @Override
    public Optional<WorkExperience> getWorkExperienceById(int id) {
        WorkExperienceDAO workExperienceDAO = crudRepository.findById(id).get();
        return Optional.ofNullable(mapper.toWorkExperience(workExperienceDAO));
    }

    @Override
    public WorkExperience saveWorkExperience(WorkExperience workExperience) {
        WorkExperienceDAO workExperienceDAO = crudRepository.save(mapper.toWorkExperienceDAO(workExperience));
        return mapper.toWorkExperience(workExperienceDAO);
    }

    @Override
    public WorkExperience updateWorkExperience(WorkExperience workExperience) {
        WorkExperienceDAO workExperienceDAO = crudRepository.save(mapper.toWorkExperienceDAO(workExperience));
        return mapper.toWorkExperience(workExperienceDAO);
    }

    @Override
    public void deleteWorkExperienceById(int id) {
        crudRepository.deleteById(id);
    }
}
