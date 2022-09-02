package com.pch.apiuserprofile.web.controller;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.services.UserProfileService;
import com.pch.apiuserprofile.dto.RequestUserProfileDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-profile")
public class UserProfileController {

    @Autowired
    private UserProfileService service;

    @GetMapping("/all")
    public ResponseEntity<List<UserProfile>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<UserProfile> save(@RequestBody UserProfile userProfile){
        UserProfile userProfile1 = service.saveUserProfile(userProfile);
        if(userProfile1 == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(userProfile1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserProfile>> getById(@PathVariable int id){
        return new ResponseEntity<>(service.getUserProfileById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserProfile> updateUserProfile(@PathVariable int id, @RequestBody RequestUserProfileDTO dto){
        UserProfile userProfile = service.updateUserProfile(id, dto);
        if(userProfile.getIdUserProfile() != 0){
            return new ResponseEntity<>(userProfile,HttpStatus.OK);
        }
        return new ResponseEntity<>(userProfile,HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/change-residence")
    public ResponseEntity<List<UserProfile>> findByChangeResidenceTrue() {
        List<UserProfile> userProfiles = service.findByChangeResidenceTrue();
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/search-city-country/{cityCountry}")
    public ResponseEntity<List<UserProfile>> findByAddressContaining(@PathVariable String cityCountry){
        List<UserProfile> userProfiles = service.findByAddressContaining(cityCountry);
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/search-technology/{technology}")
    public ResponseEntity<List<UserProfile>> findByDescriptionTechnologiesContaining(@PathVariable String technology){
        List<UserProfile> userProfiles = service.findByDescriptionTechnologiesContaining(technology);
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/exprerience-years/{experience}")
    public ResponseEntity<List<UserProfile>> findByExperienceYearsGreaterThan(@PathVariable int experience){
        List<UserProfile> userProfiles = service.findByExperienceYearsGreaterThan(experience);
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @GetMapping("/search-degree/{degree}")
    public ResponseEntity<List<UserProfile>> findByAcademicBackgroundDegreeAndAcademicBackgroundCurrentlyStudyingTrue(@PathVariable String degree){
        List<UserProfile> userProfiles = service.findByAcademicBackgroundDegreeAndAcademicBackgroundCurrentlyStudyingTrue(degree);
        return new ResponseEntity<>(userProfiles, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserProfile(@PathVariable("id") int id){
        service.deleteUserProfileById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
