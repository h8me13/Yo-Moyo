package com.yomoyo.java.services;

import com.yomoyo.java.entities.Creater;
import com.yomoyo.java.repositories.CreaterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CreaterServices {
    private final CreaterRepository createrRepository;

    public CreaterServices(CreaterRepository createrRepository) {
        this.createrRepository = createrRepository;
    }

    public List<Creater> findAllCreators(){return createrRepository.findAll();}
    public void saveNewCreater(Creater creater) { createrRepository.save(creater); }
    public void deleteCreater(Long idcreater)
    {
        createrRepository.deleteById(idcreater);
    }
    public ResponseEntity<Object> updateCreater(Long idcreater)
    {
        ResponseEntity<Object> entity = (idcreater == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        Creater creater = createrRepository.findByIdcreater(idcreater);
        entity = (creater == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        createrRepository.save(creater);
        return entity;
    }
}
