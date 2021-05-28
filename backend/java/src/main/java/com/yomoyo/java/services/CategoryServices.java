package com.yomoyo.java.services;

import com.yomoyo.java.entities.Category;
import com.yomoyo.java.entities.User;
import com.yomoyo.java.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServices {
    private final CategoryRepository categoryRepository;

    public CategoryServices(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public List<Category> findAllCategories(){ return categoryRepository.findAll();}
    public void saveCategory(Category category){
        categoryRepository.save(category);
    }
    public void deleteCategory(Long idcategory){
        categoryRepository.deleteById(idcategory);
    }
    public ResponseEntity<Object> updateUser(Long idcategory, String ctgname, String description)
    {
        ResponseEntity<Object> entity = (idcategory == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        Category category = categoryRepository.findByIdcategory(idcategory);
        entity = (category == null) ? (new ResponseEntity<Object>(HttpStatus.BAD_REQUEST)) : (new ResponseEntity<Object>(HttpStatus.OK));
        if(entity.getStatusCode() != HttpStatus.OK)
        {
            return entity;
        }
        if(ctgname != null)
        {
            category.setCtgname(ctgname);
        }
        if (description != null)
        {
            category.setDescription(description);
        }
        categoryRepository.save(category);
        return entity;
    }
}
