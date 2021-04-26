package com.yomoyo.java.services;

import com.yomoyo.java.entities.Publication;
import com.yomoyo.java.entities.User;
import com.yomoyo.java.repositories.PublicationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicationServices {
private final PublicationRepository publicationRepository;

    public PublicationServices(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }
    public List<Publication> findAllPublications(){ return publicationRepository.findAll();}
    public void saveNewPublication(Publication publication){ publicationRepository.save(publication);}
    public void deletePublication(Long idpublication){ publicationRepository.deleteById(idpublication);}
    public ResponseEntity<Object> updatePublication(Long idpublication, String heading, String text, String image)
    {
        ResponseEntity<Object> entity = (idpublication == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        Publication publication= publicationRepository.findByIdPublication(idpublication);
        entity = (publication == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        if(heading != null)
        {
            publication.setHeading(heading);
        }
        if (text != null)
        {
            publication.setText(text);
        }
        if (image != null)
        {
            publication.setImage(image);
        }
        publicationRepository.save(publication);
        return entity;
    }
}
