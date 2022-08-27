package com.pch.apiuserprofile.persistence;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.gateways.AcademicBackgroundGateway;
import com.pch.apiuserprofile.persistence.crud.AcademicBackgroudCrudRepository;
import com.pch.apiuserprofile.persistence.mappers.AcademicBackgroundMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AcademicBackgroundRepository implements AcademicBackgroundGateway {

    private AcademicBackgroudCrudRepository crudRepository;

    private AcademicBackgroundMapper mapper;

    public AcademicBackgroundRepository(AcademicBackgroudCrudRepository crudRepository, AcademicBackgroundMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }


    @Override
    public List<AcademicBackground> getAll() {
        return null;
    }

    @Override
    public Optional<List<AcademicBackground>> getByUserProfile(int idUserProfile) {
        return Optional.empty();
    }

    @Override
    public Optional<AcademicBackground> getAcademicBackgroundById(int id) {
        return Optional.empty();
    }

    @Override
    public AcademicBackground saveAcademicBackground(AcademicBackground academicBackground) {
        return null;
    }

    @Override
    public void deleteAcademicBackgroundById(int id) {

    }
}
