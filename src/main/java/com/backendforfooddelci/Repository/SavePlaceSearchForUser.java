package com.backendforfooddelci.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backendforfooddelci.Entity.EntityOfPlace;

public interface SavePlaceSearchForUser extends JpaRepository<EntityOfPlace,Long>{

}
