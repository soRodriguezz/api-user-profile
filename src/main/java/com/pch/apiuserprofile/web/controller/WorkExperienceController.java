package com.pch.apiuserprofile.web.controller;

import com.pch.apiuserprofile.domain.entities.WorkExperience;
import com.pch.apiuserprofile.domain.services.WorkExperienceService;
import com.pch.apiuserprofile.dto.RequestWorkExperienceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/work-experience")
public class WorkExperienceController {

    @Autowired
    private WorkExperienceService service;

    @GetMapping("/all")
    public ResponseEntity<List<WorkExperience>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<WorkExperience> save(@RequestBody RequestWorkExperienceDTO dto){
        WorkExperience workExperience = service.saveWorkExperience(dto);
        if(workExperience == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(workExperience, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<WorkExperience>> getByWorkExperience(@PathVariable int id){
        return new ResponseEntity<>(service.getWorkExperienceById(id), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<List<WorkExperience>>> getByIdUserProfile(@PathVariable int id){
        return new ResponseEntity<>(service.getByIdUserProfile(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WorkExperience> update(@PathVariable int id, @RequestBody RequestWorkExperienceDTO dto){
        WorkExperience workExperience = service.updateWorkExperience(id, dto);
        if(workExperience == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(workExperience, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        service.deleteWorkExperienceById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}
