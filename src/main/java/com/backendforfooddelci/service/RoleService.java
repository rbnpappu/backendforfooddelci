package com.backendforfooddelci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backendforfooddelci.Entity.RegisterUserRole;
import com.backendforfooddelci.Repository.RoleDao;



@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	public RegisterUserRole createNewRole(RegisterUserRole role) {
		return roleDao.save(role);

	}

}
