package com.yomoyo.java.repositories;

import com.yomoyo.java.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepository extends JpaRepository<Publication,Long> {
     Publication findByIdPublication(Long idpublication);
}
