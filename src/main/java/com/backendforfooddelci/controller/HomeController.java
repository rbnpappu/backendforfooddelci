package com.backendforfooddelci.controller;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backendforfooddelci.Entity.FileResponse;
import com.backendforfooddelci.Entity.FindResrtrotantCuisineFoodName;
import com.backendforfooddelci.Entity.FoodMenu;
import com.backendforfooddelci.Entity.Restaurant;
import com.backendforfooddelci.Entity.RegisterUser;

import com.backendforfooddelci.service.EmailService;
import com.backendforfooddelci.service.FileService;
import com.backendforfooddelci.service.ForFindRestutantByGivenlatlag;
import com.backendforfooddelci.service.RestroRepoService;
import com.backendforfooddelci.service.SignUpService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import com.backendforfooddelci.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class HomeController {
	
private final SignUpService userService;

private final RestroRepoService restroService;

private final EmailService sendMailService;

private final ForFindRestutantByGivenlatlag  forFindResturantByService;


private final ServiceForFindResrtrotantCuisineFoodName findServiceByRedturantandcuisinefoodName;

	public HomeController(SignUpService userService, RestroRepoService restroService, FileService service, EmailService sendMailService,ForFindRestutantByGivenlatlag   forFindResturantByService, ServiceForFindResrtrotantCuisineFoodName findServiceByRedturantandcuisinefoodName ) {
		this.userService = userService;
		this.restroService = restroService;
		this.forFindResturantByService =  forFindResturantByService;
		this.service = service;
		this.sendMailService = sendMailService; 
		this.findServiceByRedturantandcuisinefoodName = findServiceByRedturantandcuisinefoodName ;
	}
	
    @PostMapping("/RegisterUser")
    public ResponseEntity<RegisterUser> signUpUser(@Valid @RequestBody RegisterUser user) {
    	
         userService.save(user);
         sendMailService.sendEmail(user); 
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userService.get())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    
    

    @PostMapping("/RegisterRestro")
    public ResponseEntity<Restaurant> registerRestro(@Valid @RequestBody Restaurant restro) throws IOException{
    
		restroService.save(restro);
    	
	
		
		  URI location = ServletUriComponentsBuilder.fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(restroService)
	                .toUri();
		
		return ResponseEntity.created(location).build();
    	
    }
    


//    @PreAuthorize("hasAuthority('SCOPE_ROLE_admin')")
    @GetMapping("/RegisterRestro")
    public Iterable<Restaurant> RetriveRestro() throws IOException{
    	
		return restroService.findAll();
    }
    
    @Value("${project.image}")
    String path;
    
    @Autowired
    private final FileService service;

  

    @PostMapping("/upload")
    public ResponseEntity<FileResponse> fileupload(
            @RequestParam("image") MultipartFile image) throws java.io.IOException{
        // Call the service method to handle the file upload
    	String fileName = null;
    	try {
    		fileName = service.uploadImage(path, image);
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    		return new ResponseEntity<>(new FileResponse(null,"file is not uploaded in path directory"),HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	
        // You can process the response further if needed
    	return new ResponseEntity<>(new FileResponse(fileName,"file is uploaded in path directory"),HttpStatus.OK);
    }


    
    @GetMapping(value="/images/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException {
    	InputStream resource = this.service.getResource(path, imageName);
    	response.setContentType(MediaType.IMAGE_JPEG_VALUE);
    	StreamUtils.copy(resource, response.getOutputStream());
    }

	
    @GetMapping(value = "/trending")
    public List<Restaurant> trendingPlaces(@RequestParam("lat") double latitude,
                                           @RequestParam("lon") double longitude,
                                           HttpServletResponse response) throws IOException {
        List<Restaurant> listOfRestaurants = forFindResturantByService.findRestaurantsByLatitudeAndLongitudeTopTrending(latitude, longitude);
        List<Restaurant> filteredRestaurants = forFindResturantByService.filterOutByReview(listOfRestaurants);
        return filteredRestaurants;
    }
    
    @GetMapping(value="/findFoodRestutantAndcuisine/{value}")
    public List<FindResrtrotantCuisineFoodName> ServiceForFindResrtrotantCuisineFoodName(@PathVariable("value") String value){
        // Get the lists from the service
    	List<FindResrtrotantCuisineFoodName> resultRestaurant = new ArrayList<>();

    	List<Restaurant> restaurants = findServiceByRedturantandcuisinefoodName.findRestaurantByCriteria(value);
    	List<FoodMenu> menus = findServiceByRedturantandcuisinefoodName.findFoodByNameByCriteria(value);
    	List<Restaurant> restaurantByCriteria = findServiceByRedturantandcuisinefoodName.findCusineByCriteria(value);
    	
    	System.out.println(value);

    	// Check and add the restaurant results if not null
    	if (restaurants != null) {
    	    resultRestaurant.addAll(restaurants.stream()
    	            .filter(Objects::nonNull) // Filter out null entries
    	            .map(res -> new FindResrtrotantCuisineFoodName(res.getId(), res.getRestName(), "Restaurant", res.getRestoImages()))
    	            .collect(Collectors.toList()));
    	}

    	// Check and add the restaurantByCriteria results if not null
    	if (restaurantByCriteria != null) {
    	    resultRestaurant.addAll(restaurantByCriteria.stream()
    	            .filter(Objects::nonNull) // Filter out null entries
    	            .map(res -> new FindResrtrotantCuisineFoodName(res.getId(), res.getRestName(), "Restaurant", res.getRestoImages()))
    	            .collect(Collectors.toList()));
    	}

    	// Check and add the menu results if not null
    	if (menus != null) {
    	    resultRestaurant.addAll(menus.stream()
    	            .filter(Objects::nonNull) // Filter out null entries
    	            .map(menu -> new FindResrtrotantCuisineFoodName(menu.getId(), menu.getFoodName(), "Order Online", menu.getFoodImage()))
    	            .collect(Collectors.toList()));
    	}

    	return resultRestaurant;
    }
    
    @PostMapping("/Restaurant/menus/{id}")
    public FoodMenu addMenuForRestaurant(@PathVariable("id")Long id,@Valid @RequestBody FoodMenu menu) {
        return restroService.addMenuForRestaurant(id, menu);
    }

}
