package com.pch.apiuserprofile.web.controller;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user-profile")
public class UserController {

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

    @PutMapping("/update")
    public ResponseEntity<UserProfile> updateUserProfile(@RequestBody UserProfile userProfile){
        if(userProfile.getIdUserProfile() != 0){
            UserProfile user2 = service.updateUserProfile(userProfile);
            return new ResponseEntity<>(user2,HttpStatus.OK);
        }
        return new ResponseEntity<>(userProfile,HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> updateUserProfile(@PathVariable("id") int id){
        service.deleteUserProfileById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
