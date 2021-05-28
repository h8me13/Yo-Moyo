package com.yomoyo.java.repositories;

import com.yomoyo.java.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
  Category findByIdcategory(Long idcategory);
}
