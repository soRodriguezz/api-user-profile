package com.pch.apiuserprofile.persistence.crud;

import com.pch.apiuserprofile.persistence.models.CertificationDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CertificationCrudRepository extends CrudRepository<CertificationDAO, Integer> {
    List<CertificationDAO> findByIdUserProfile(int idUserProfile);
}
