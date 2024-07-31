package com.backendforfooddelci.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.backendforfooddelci.Entity.BookSeats;
import com.backendforfooddelci.Entity.EntityOfPlace;
import com.backendforfooddelci.Entity.FoodMenu;
import com.backendforfooddelci.Entity.Restaurant;
import com.backendforfooddelci.service.RestroRepoService;
import com.backendforfooddelci.service.ServiceForFindTheUserPlaceByText;

import jakarta.validation.Valid;

@RestController
public class UserPagefilterController {

	private final ServiceForFindTheUserPlaceByText serviceForFindPlace;
	
	public UserPagefilterController(RestroRepoService service, ServiceForFindTheUserPlaceByText serviceForFindPlace) {
		super();
		this.service = service;
		this.serviceForFindPlace = serviceForFindPlace;
	}

	private final RestroRepoService service;
 
	 @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
	  @GetMapping("/cuisine/{cuisine}")
	    public List<Restaurant> cuisine(@PathVariable("cuisine") String cuisine) {
	        return service.findByCuisine(cuisine);
	    }
	 
	  @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
	  @PostMapping("/register/bookseats/{id}")
	 public void bookSeats(@PathVariable("id") int id, @Valid @RequestBody BookSeats seatInfo) {
	     List<BookSeats> seatsList = new ArrayList<>();
	     seatsList.add(seatInfo);
	     service.bookSeats(id, seatsList); // Pass the list containing seatInfo
	 }

	  
	  @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
		 @PostMapping("/register/menu/{id}")
		 public void menuForRestarutant(@PathVariable("id") int id, @Valid @RequestBody List<FoodMenu> menu) {
		     List<FoodMenu> menuList = new ArrayList<>();
		     menuList.addAll(menu);
		     service.menuList(id, menu); // Pass the list containing seatInfo
		 }
	  
	  @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
	  @GetMapping("/register/{review}")
	  public List<Restaurant> reviewByItem(@PathVariable("review") int review) {
	        return service.findByRestroReview(review);
	    }
	  
	  @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
	  @GetMapping("/register/sortReview")
	  public List<Restaurant> reviewByHighertoLowerFoodItem() {
	        return service.findByRestroReviewHighertoLowerFoodItem();
	    }
	  
	  @GetMapping("/places/{userInput}")
	  public List<EntityOfPlace> findPlaceByUserInput(@PathVariable("userInput") String userInput){
		  return serviceForFindPlace.fetchGooglePlacesByName(userInput); 
	  }
	  
//	  @GetMapping("/searchrestutantcusinedish/{}")
//	  public List<>
}
