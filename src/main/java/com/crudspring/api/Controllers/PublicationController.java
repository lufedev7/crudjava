package com.crudspring.api.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudspring.api.DTOs.PublicationDTO;
import com.crudspring.api.Services.PublicationServices;

@RestController
@RequestMapping("/publication")
public class PublicationController {

    @GetMapping
    public List<PublicationDTO> listPublication(
            @RequestParam(value = "nomPage", defaultValue = "0", required = false) int numberPage,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) int measure) {
        return publicationservices.getpublication(numberPage, measure);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> getPublicationForId(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(publicationservices.getpublicationId(id));
    }

    @Autowired
    private PublicationServices publicationservices;

    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@RequestBody PublicationDTO publicationdto) {
        return new ResponseEntity<>(publicationservices.createpublication(publicationdto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> updatePublicationForId(@RequestBody PublicationDTO publicationdto,
            @PathVariable(name = "id") Long id) {
        PublicationDTO publicationresponse = publicationservices.updatePublication(publicationdto, id);

        return new ResponseEntity<>(publicationresponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePublication(@PathVariable(name = "id") long id) {
        publicationservices.deletePublication(id);
        return new ResponseEntity<>("Publication delete with success", HttpStatus.OK);
    }
}
