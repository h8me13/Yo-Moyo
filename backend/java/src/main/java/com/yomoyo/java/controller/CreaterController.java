package com.yomoyo.java.controller;

import com.yomoyo.java.entities.Creater;
import com.yomoyo.java.entities.Publication;
import com.yomoyo.java.services.CreaterServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Creater")
public class CreaterController {
    private final CreaterServices createrServices;

    public CreaterController(CreaterServices createrServices) {
        this.createrServices = createrServices;
    }
    @GetMapping(path="all")
    @CrossOrigin("http://localhost:8080")
    public List<Creater> findCreators(){ return createrServices.findAllCreators();}
    @PostMapping(path="/new")
    @CrossOrigin("http://localhost:8080")
    public void addCreater(@RequestBody Creater creater){ createrServices.saveNewCreater(creater);}
    @PutMapping(path="/update")
    @CrossOrigin("http://localhost:8080")
    public void updateCreater(@RequestBody Creater creater){
        createrServices.updateCreater(creater.getIdcreater());}
    @DeleteMapping(path="/deletebyid")
    @CrossOrigin("http://localhost:8080")
    public void deleteCreator(@RequestParam Long idcreater){ createrServices.deleteCreater(idcreater);}
}
