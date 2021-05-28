package com.yomoyo.java.repositories;

import com.yomoyo.java.entities.Creater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreaterRepository extends JpaRepository<Creater,Long> {
    Creater findByIdcreater(Long idcreater);
}
