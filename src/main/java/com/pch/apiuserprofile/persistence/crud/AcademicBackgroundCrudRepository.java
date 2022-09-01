package com.pch.apiuserprofile.persistence.crud;

import com.pch.apiuserprofile.persistence.models.AcademicBackgroundDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AcademicBackgroundCrudRepository extends CrudRepository<AcademicBackgroundDAO, Integer> {
    List<AcademicBackgroundDAO> findByIdUserProfile(int idUserProfile);
}
