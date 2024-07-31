package com.backendforfooddelci.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.backendforfooddelci.Entity.FoodMenu;
import com.backendforfooddelci.Entity.Restaurant;
import com.backendforfooddelci.Repository.MenuForRestaurantRepository;
import com.backendforfooddelci.Repository.RestroRepository;



@Service
public class ServiceForFindResrtrotantCuisineFoodName {
	
	private RestroRepository repository;
	private MenuForRestaurantRepository menuRepo;
	
	
	public ServiceForFindResrtrotantCuisineFoodName(RestroRepository repository, MenuForRestaurantRepository menuRepo) {
		super();
		this.repository = repository;
		this.menuRepo = menuRepo;
	}


	public List<Restaurant> findRestaurantByCriteria(String name) {
	    List<Restaurant> results = new ArrayList<>();

	    // Check if the name corresponds to a restaurant name
	    List<Restaurant> restaurantsByName = repository.findByRestNameContaining(name);

	    if (restaurantsByName != null && !restaurantsByName.isEmpty()) {
	        results.addAll(restaurantsByName);
	    }

	    System.out.print( repository. findByRestNameContaining(name)+"restocalled");
	    
	    // Return null or an empty list if no matches are found
	    return results.isEmpty() ? null : results;
	}
	
	

	public List<Restaurant> findCusineByCriteria(String name) {
	    List<Restaurant> results = new ArrayList<>();

	    // Check if the name corresponds to a restaurant name
	    List<Restaurant> restaurantsByName = repository.findByCuisine(name);
	    if (restaurantsByName != null && !restaurantsByName.isEmpty()) {
	        results.addAll(restaurantsByName);
	    }

	    
	    // Return null or an empty list if no matches are found
	    return results.isEmpty() ? null : results;
	}
	

	public List<FoodMenu> findFoodByNameByCriteria(String name) {
	    List<FoodMenu> results = new ArrayList<>();

	    // Check if the name corresponds to a restaurant name
	    List<FoodMenu> menusByName = menuRepo.findByFoodName("chi");

	    if (menusByName  != null && !menusByName.isEmpty()) {
	        results.addAll(menusByName);
	    }

	    
	    // Return null or an empty list if no matches are found
	    return results.isEmpty() ? null : results;
	}
}
