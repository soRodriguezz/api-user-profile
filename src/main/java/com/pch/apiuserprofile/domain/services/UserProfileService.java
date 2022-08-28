package com.pch.apiuserprofile.domain.services;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.gateways.UserProfileGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserProfileService {

    @Autowired
    private UserProfileGateway gateway;

    public List<UserProfile> getAll(){
        return gateway.getAll();
    }

    public Optional<UserProfile> getUserProfileById(int id){
        return gateway.getUserProfileById(id);
    }

    public UserProfile saveUserProfile(UserProfile userProfile){

        Date dateBirth = userProfile.getDateBirth();
        int age = userProfile.getAge();

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        String dateBirthToString = dateFormat.format(dateBirth);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate dateBith1 = LocalDate.parse(dateBirthToString, fmt);

        LocalDate now = LocalDate.now();
        Period date = Period.between(dateBith1, now);

        if(date.getYears() != age){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La fecha de nacimiento no concuerda con la edad");
        }

        return gateway.saveUserProfile(userProfile);
    }

    public UserProfile updateUserProfile(UserProfile userProfile){
        return gateway.updateUserProfile(userProfile);
    }

    public void deleteUserProfileById(int id){
        getUserProfileById(id).map(userProfile -> {
            gateway.deleteUserProfileById(id);
            return true;
        });
    }

}
