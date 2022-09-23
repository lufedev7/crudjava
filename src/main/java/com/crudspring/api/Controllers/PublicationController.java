package com.crudspring.api.Controllers;



import javax.validation.Valid;

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
import com.crudspring.api.DTOs.PublicationResponse;
import com.crudspring.api.Services.PublicationServices;
import com.crudspring.api.Utililies.AppConst;

@RestController
@RequestMapping("/publication")
public class PublicationController {
    @Autowired
    private PublicationServices publicationservices;

    @GetMapping
    public PublicationResponse listPublication(
            @RequestParam(value = "nomPage", defaultValue = AppConst.Mesure_page_for_default, required = false) int numberPage,
            @RequestParam(value = "pageSize", defaultValue = AppConst.Number_page_for_default, required = false) int measure,
            @RequestParam(value = "sortBy", defaultValue = AppConst.Order_by_for_default, required = false) String orderBy,
            @RequestParam(value = "sortdir", defaultValue = AppConst.Order_by_for_dir, required = false) String sortDir) {
        return publicationservices.getpublication(numberPage, measure, orderBy, sortDir);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublicationDTO> getPublicationForId(@PathVariable(name = "id") Long id) {

        return ResponseEntity.ok(publicationservices.getpublicationId(id));
    }



    @PostMapping
    public ResponseEntity<PublicationDTO> savePublication(@Valid @RequestBody PublicationDTO publicationdto) {
        return new ResponseEntity<>(publicationservices.createpublication(publicationdto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationDTO> updatePublicationForId(@Valid @RequestBody PublicationDTO publicationdto,
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
