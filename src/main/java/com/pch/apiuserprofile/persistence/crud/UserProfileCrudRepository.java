package com.pch.apiuserprofile.persistence.crud;

import com.pch.apiuserprofile.persistence.models.UserProfileDAO;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileCrudRepository extends CrudRepository<UserProfileDAO, Integer> {

}
