package com.backendforfooddelci.service;

import java.io.IOException;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.backendforfooddelci.Entity.BookSeats;
import com.backendforfooddelci.Entity.FoodMenu;
import com.backendforfooddelci.Entity.Restaurant;
import com.backendforfooddelci.Repository.MenuForRestaurantRepository;
import com.backendforfooddelci.Repository.RestroRepository;

import jakarta.validation.Valid;

@Service
public class RestroRepoService {
	

	
	@Autowired
	private  RestroRepository service;
	
	@Autowired
	private MenuForRestaurantRepository menuservice;
	
	public Restaurant save(Restaurant restro) throws IOException {
	

		
		return service.save(restro);
		
	}

	
	public Iterable<Restaurant> findAll(){
		return service.findAll();
		
	}


	public List<Restaurant> findByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return service.findByCuisine(cuisine);
	}


//	public void bookSeats(int id, @Valid BookSeats seatInfo) {
//		// TODO Auto-generated method stub
//	service.saveBookSeatsForRestarutant(seatInfo, id);
//		
//	}
//	


	public List<Restaurant> findByRestroReview(int review) {
		// TODO Auto-generated method stub
		return service.findByReview(review);
	}


	public List<Restaurant> findByRestroReviewHighertoLowerFoodItem() {
		// TODO Auto-generated method stub
		return service.findAllByOrderByReviewDesc();
	}


	public void bookSeats(int id, @Valid List<BookSeats> seatInfo) {
	    Optional<Restaurant> restaurantOptional = service.findById(id);

	    if (restaurantOptional.isPresent()) {
	        Restaurant restaurant = restaurantOptional.get();
	        
	        // Set the bookSeats for the restaurant
	        restaurant.setBookSeats(seatInfo);
	        
	        // Save the restaurant
	        service.save(restaurant);
	    } else {
	        // Handle case where Restaurant with provided ID doesn't exist
	        // You can throw an exception or handle it according to your application's logic
	    }
	}

	  public FoodMenu addMenuForRestaurant(Long restaurantId, FoodMenu menu) {
	        // Find the restaurant by ID
	        Restaurant restaurant = service.findById(restaurantId).orElse(null);
	        if (restaurant != null) {
	            // Set the restaurant to the menu
	            menu.setRestaurant(restaurant);
	            // Save the menu
	            return menuservice.save(menu);
	        }
	        return null; // Handle the case where the restaurant does not exist
	    }
	  
	public void menuList(int id, @Valid List<FoodMenu> menu) {
		// TODO Auto-generated method stub
		 Optional<Restaurant> restaurantOptional = service.findById(id);

		    if (restaurantOptional.isPresent()) {
		        Restaurant restaurant = restaurantOptional.get();
		        
		        // Set the bookSeats for the restaurant
		        restaurant.setMenus(menu);
		        
		        // Save the restaurant
		        service.save(restaurant);
		    }
		
	}

	
	


}
