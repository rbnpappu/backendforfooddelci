package com.backendforfooddelci.Repository;

import org.springframework.data.repository.CrudRepository;

import com.backendforfooddelci.Entity.Menuforrestotant;
import com.backendforfooddelci.Entity.RegisterRestrutant;

public interface MenuRepository extends CrudRepository<Menuforrestotant , Long> {

}
