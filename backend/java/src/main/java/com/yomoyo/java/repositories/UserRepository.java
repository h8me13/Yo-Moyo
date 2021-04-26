package com.yomoyo.java.repositories;

import com.yomoyo.java.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long>{

    User findByIduser(Long iduser);
}
