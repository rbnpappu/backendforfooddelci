package com.backendforfooddelci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backendforfooddelci.Entity.FoodMenu;
import com.backendforfooddelci.Repository.MenuForRestaurantRepository;


@Service
public class MenuService {
	
	@Autowired
	private MenuForRestaurantRepository service;
	
	public FoodMenu  createmenu(FoodMenu menu, String fileName) {
		
		menu.setFoodImage(fileName);
	
		return service.save(menu);
		
	}
}
