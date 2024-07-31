package com.backendforfooddelci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendforfooddelci.Entity.RegisterUser;
import com.backendforfooddelci.Repository.RegisterRepository;



@Service
public class SignUpService {

    private final RegisterRepository service;


    @Autowired
    public SignUpService(RegisterRepository service ) {
        this.service = service;

    }

    public void save(RegisterUser user) {
         service.save(user);
    }


    public Iterable<RegisterUser> get() {
        return service.findAll();
    }

    public Iterable<RegisterUser> getAdminUser(){
    	return service.findAll();
    }
    
    
}
