package com.yomoyo.java.controller;

import com.yomoyo.java.entities.Category;
import com.yomoyo.java.entities.Sub;
import com.yomoyo.java.services.CategoryServices;
import com.yomoyo.java.services.SubServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/Sub")
public class SubController {
    private final SubServices subServices;

    public SubController(SubServices subServices) {
        this.subServices = subServices;
    }
    @GetMapping(path= "all")
    @CrossOrigin("http://localhost:8080")
    public List<Sub> findSubs(){ return subServices.findAllSubs();}
    @PostMapping(path="new")
    @CrossOrigin("http://localhost:8080")
    public void addNewSub(@RequestBody Sub sub){ subServices.saveSub(sub);}
    @PutMapping(path="update")
    @CrossOrigin("http://localhost:8080")
    public void updateSub(@RequestBody Sub sub){
        subServices.updateSub(sub.getIdsub());}
    @DeleteMapping(path = "deletebyid")
    @CrossOrigin("http://localhost:8080")
    public void deleteCategory(@RequestParam Long idsub){ subServices.deleteSub(idsub);}
}
