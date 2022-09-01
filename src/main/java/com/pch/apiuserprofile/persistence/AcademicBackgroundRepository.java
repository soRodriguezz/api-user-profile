package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.gateways.AcademicBackgroundGateway;
import com.pch.apiuserprofile.persistence.crud.AcademicBackgroundCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.AcademicBackgroundMapper;
import com.pch.apiuserprofile.persistence.models.AcademicBackgroundDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AcademicBackgroundRepository implements AcademicBackgroundGateway {

    private final AcademicBackgroundCrudRepository crudRepository;

    private final AcademicBackgroundMapper mapper;

    public AcademicBackgroundRepository(AcademicBackgroundCrudRepository crudRepository, AcademicBackgroundMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<AcademicBackground> getAll() {
        List<AcademicBackgroundDAO> daos = (List<AcademicBackgroundDAO>) crudRepository.findAll();
        return mapper.toAcademicBackgrounds(daos);
    }

    @Override
    public Optional<List<AcademicBackground>> getByIdUserProfile(int idUserProfile) {
        List<AcademicBackgroundDAO> daos = crudRepository.findByIdUserProfile(idUserProfile);
        return Optional.ofNullable(mapper.toAcademicBackgrounds(daos));
    }

    @Override
    public Optional<AcademicBackground> getAcademicBackgroundById(int id) {
        AcademicBackgroundDAO academicBackgroundDAO = crudRepository.findById(id).get();
        return Optional.ofNullable(mapper.toAcademicBackground(academicBackgroundDAO));
    }

    @Override
    public AcademicBackground saveAcademicBackground(AcademicBackground academicBackground) {
        AcademicBackgroundDAO academicBackgroundDAO = crudRepository.save(mapper.toAcademicBackgroundDAO(academicBackground));
        return mapper.toAcademicBackground(academicBackgroundDAO);
    }

    @Override
    public AcademicBackground updateAcademicBackground(AcademicBackground academicBackground) {
        AcademicBackgroundDAO academicBackgroundDAO = crudRepository.save(mapper.toAcademicBackgroundDAO(academicBackground));
        return mapper.toAcademicBackground(academicBackgroundDAO);
    }

    @Override
    public void deleteAcademicBackgroundById(int id) {
        crudRepository.deleteById(id);
    }
}
