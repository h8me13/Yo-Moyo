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
    public List<Category> findCategories(){ return categoryServices.findAllCategories();}
    @PostMapping(path="new")
    public void addNewCategory(@RequestBody Category category){ categoryServices.saveCategory(category);}
    @PutMapping(path="update")
    public void updateCategory(@RequestBody Category category){
        categoryServices.updateUser(category.getIdcategory(),category.getCtgname(),category.getDescription());}
    @DeleteMapping(path = "deletebyid")
    public void deleteCategory(@RequestParam Long idcategory){ categoryServices.deleteCategory(idcategory);}
}
