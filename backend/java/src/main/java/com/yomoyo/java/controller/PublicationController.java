package com.yomoyo.java.controller;

import com.yomoyo.java.entities.Publication;
import com.yomoyo.java.services.PublicationServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Publications")
public class PublicationController {
    private final PublicationServices publicationServices;

    public PublicationController(PublicationServices publicationServices) {
        this.publicationServices = publicationServices;
    }
    @GetMapping(path="/all")
    public List<Publication> findPublications(){return publicationServices.findAllPublications();}
    @PostMapping(path="/new")
    public void addPublication(@RequestBody Publication publication){ publicationServices.saveNewPublication(publication);}
    @PutMapping(path="/update")
    public void updatePublication(@RequestBody Publication publication){
        publicationServices.updatePublication(publication.getIdpublication(),publication.getHeading(),publication.getText(),publication.getImage());}
    @DeleteMapping(path="/deletebyid")
    public void deletePublication(@RequestParam Long idpublication){ publicationServices.deletePublication(idpublication);}
}
