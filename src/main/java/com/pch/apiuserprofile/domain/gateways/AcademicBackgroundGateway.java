package com.pch.apiuserprofile.domain.gateways;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;

import java.util.List;
import java.util.Optional;

public interface AcademicBackgroundGateway {
    List<AcademicBackground> getAll();

    Optional<List<AcademicBackground>> getByIdUserProfile(int idUserProfile);

    Optional<AcademicBackground> getAcademicBackgroundById(int id);

    AcademicBackground saveAcademicBackground(AcademicBackground academicBackground);

    AcademicBackground updateAcademicBackground(AcademicBackground academicBackground);

    void deleteAcademicBackgroundById(int id);
}
