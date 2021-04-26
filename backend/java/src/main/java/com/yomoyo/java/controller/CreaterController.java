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
    public List<Creater> findCreators(){ return createrServices.findAllCreators();}
    @PostMapping(path="/new")
    public void addCreater(@RequestBody Creater creater){ createrServices.saveNewCreater(creater);}
    @PutMapping(path="/update")
    public void updateCreater(@RequestBody Creater creater){
        createrServices.updateCreater(creater.getIdcreater());}
    @DeleteMapping(path="/deletebyid")
    public void deleteCreator(@RequestParam Long idcreater){ createrServices.deleteCreater(idcreater);}
}
