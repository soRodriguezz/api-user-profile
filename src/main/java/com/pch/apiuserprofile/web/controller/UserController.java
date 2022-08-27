package com.pch.apiuserprofile.web.controller;

import com.pch.apiuserprofile.domain.entities.UserProfile;
import com.pch.apiuserprofile.domain.services.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
