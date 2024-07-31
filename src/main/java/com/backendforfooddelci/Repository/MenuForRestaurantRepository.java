package com.backendforfooddelci.Repository;



import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;


import com.backendforfooddelci.Entity.FoodMenu;

import org.springframework.data.jpa.repository.JpaRepository;

	public interface MenuForRestaurantRepository extends JpaRepository<FoodMenu, Long> {

		@Query("SELECT m FROM FoodMenu m WHERE m.cuisine LIKE %:name% OR m.cuisine = :name")
	    List<FoodMenu> findByType(@Param("name") String name);

		@Query("SELECT m FROM FoodMenu m WHERE m.foodName LIKE %:name%")
	    List<FoodMenu> findByFoodName(@Param("name") String name);
	    
		@Query("SELECT COUNT(m) FROM FoodMenu m JOIN m.restaurant r WHERE r.id = :restaurantId AND m.review >= 3")
	    double countMenusWithHighReviewsByRestaurantId(@Param("restaurantId") Long restaurantId);
	    
	}


