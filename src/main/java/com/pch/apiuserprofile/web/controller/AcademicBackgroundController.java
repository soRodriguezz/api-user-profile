package com.pch.apiuserprofile.web.controller;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.services.AcademicBackgroundService;
import com.pch.apiuserprofile.dto.RequestAcademicBackgroundDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/academic-background")
public class AcademicBackgroundController {

    @Autowired
    private AcademicBackgroundService service;

    @GetMapping("/all")
    public ResponseEntity<List<AcademicBackground>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<AcademicBackground> save(@RequestBody RequestAcademicBackgroundDTO dto){
        AcademicBackground academicBackground1 = service.saveAcademicBackground(dto);
        if(academicBackground1 == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(academicBackground1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<AcademicBackground>> getByIdAcademicBackground(@PathVariable int id){
        return new ResponseEntity<>(service.getAcademicBackgroundById(id), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<List<AcademicBackground>>> getByIdUserProfile(@PathVariable int id){
        return new ResponseEntity<>(service.getByIdUserProfile(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AcademicBackground> update(@PathVariable int id, @RequestBody RequestAcademicBackgroundDTO dto){
        AcademicBackground academicBackground1 = service.updateAcademicBackground(id, dto);
        if(academicBackground1 == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(academicBackground1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        service.deleteAcademicById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }

}
