package com.yomoyo.java.services;
import com.yomoyo.java.entities.Sub;
import com.yomoyo.java.repositories.SubRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubServices {
    private final SubRepository subRepository;

    public SubServices(SubRepository subRepository) {
        this.subRepository = subRepository;
    }
    public List<Sub> findAllSubs(){return subRepository.findAll();}
    public void saveSub(Sub sub) { subRepository.save(sub); }
    public void deleteSub(Long idsub)
    {
        subRepository.deleteById(idsub);
    }
    public ResponseEntity<Object> updateSub(Long idsub)
    {
        ResponseEntity<Object> entity = (idsub == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        Sub sub = subRepository.findByIdsub(idsub);
        entity = (sub == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        subRepository.save(sub);
        return entity;
    }
}
