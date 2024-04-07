package com.backendforfooddelci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.backendforfooddelci.Entity.Menuforrestotant;
import com.backendforfooddelci.Repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository service;
	
	public Menuforrestotant  createmenu(Menuforrestotant menu, String fileName) {
		
		menu.setFoodImage(fileName);
	
		return service.save(menu);
		
	}
}
