package com.yomoyo.java.repositories;

import com.yomoyo.java.entities.Sub;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubRepository extends JpaRepository<Sub, Long> {
    Sub findByIdsub(Long idsub);
}
