package com.crudspring.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.api.DTOs.PublicationDTO;
import com.crudspring.api.Services.PublicationServices;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    
    @Autowired
    private PublicationServices publicationservices;
    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@RequestBody PublicationDTO publicationdto){
        return new ResponseEntity<>(publicationservices.createpublication(publicationdto),HttpStatus.CREATED);
    }
    @GetMapping
    public List <PublicationDTO> listPublication(){
        return publicationservices.getpublication();
    }
    @GetMapping("/{id}")
    public ResponseEntity <PublicationDTO> getPublicationForId(@PathVariable(name="id")Long id){
        
        return ResponseEntity.ok(publicationservices.getpublicationId(id));
    }
}
