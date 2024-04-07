package com.backendforfooddelci.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.backendforfooddelci.Entity.RegisterUser;


@Repository
public interface RegisterRepository extends CrudRepository<RegisterUser, Long> {



	Optional<RegisterUser> findByUserName(String userName);



}