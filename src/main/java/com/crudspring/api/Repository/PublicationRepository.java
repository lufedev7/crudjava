package com.crudspring.api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crudspring.api.Models.Publication;

public interface PublicationRepository extends JpaRepository<Publication,Long>{
    
}
