package com.pch.apiuserprofile.web.controller;

import com.pch.apiuserprofile.domain.entities.AcademicBackground;
import com.pch.apiuserprofile.domain.entities.Certification;
import com.pch.apiuserprofile.domain.services.CertificationService;
import com.pch.apiuserprofile.dto.RequestAcademicBackgroundDTO;
import com.pch.apiuserprofile.dto.RequestCertificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/certification")
public class CertificationController {

    @Autowired
    private CertificationService service;

    @GetMapping("/all")
    public ResponseEntity<List<Certification>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<Optional<List<Certification>>> getByIdUserProfile(@PathVariable int id){
        return new ResponseEntity<>(service.getByIdUserProfile(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Certification>> getByIdCertificacion(@PathVariable int id){
        return new ResponseEntity<>(service.getCertificationById(id), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Certification> save(@RequestBody RequestCertificationDTO dto){
        Certification certification = service.saveCertification(dto);
        if(certification == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(certification, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Certification> update(@PathVariable int id, @RequestBody RequestCertificationDTO dto){
        Certification certification = service.updateCertification(id, dto);
        if(certification == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(certification, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id){
        service.deleCertificationById(id);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}
