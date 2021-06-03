package com.yomoyo.java.controller;

import com.yomoyo.java.entities.Category;
import com.yomoyo.java.services.CategoryServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Categories")
public class CategoryController {
    public final CategoryServices categoryServices;

    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }
    @GetMapping(path= "all")
    @CrossOrigin("http://localhost:8080")
    public List<Category> findCategories(){ return categoryServices.findAllCategories();}
    @PostMapping(path="new")
    @CrossOrigin("http://localhost:8080")
    public void addNewCategory(@RequestBody Category category){ categoryServices.saveCategory(category);}
    @PutMapping(path="update")
    @CrossOrigin("http://localhost:8080")
    public void updateCategory(@RequestBody Category category){
        categoryServices.updateUser(category.getIdcategory(),category.getCtgname(),category.getDescription());}
    @DeleteMapping(path = "deletebyid")
    @CrossOrigin("http://localhost:8080")
    public void deleteCategory(@RequestParam Long idcategory){ categoryServices.deleteCategory(idcategory);}
}
