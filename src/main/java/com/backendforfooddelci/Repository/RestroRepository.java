package com.backendforfooddelci.Repository;



import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.backendforfooddelci.Entity.Restaurant;


public interface RestroRepository extends  CrudRepository<Restaurant, Long>{

	List<Restaurant> findByCuisine(String cuisine);

	Optional<Restaurant>  findById(int id);
	

    List<Restaurant> findByRestNameContaining(String name);


	List<Restaurant> findByReview(int review);
	
	 List<Restaurant> findAllByOrderByReviewDesc();
	 
	 @Query(value = "SELECT r.*, " +
             "(6371 * acos(cos(radians(:userLatitude)) * cos(radians(r.latitude)) * cos(radians(r.longitude) - radians(:userLongitude)) + sin(radians(:userLatitude)) * sin(radians(r.latitude)))) AS distance " +
             "FROM Restaurant r " +
             "HAVING distance < :radius " +
             "ORDER BY distance", nativeQuery = true)
List<Restaurant> findNearbyRestaurants(
      @Param("userLongitude") double userLongitude,
      @Param("userLatitude") double userLatitude,
      @Param("radius") double radius);
	 

	 
	 @Query("SELECT COUNT(m) FROM FoodMenu m WHERE m.restaurant.id = :restaurantId AND m.foodReview >= 4.5")
	    long countMenuItemsWithReviewGreaterThanEqual(@Param("restaurantId") Long restaurantId);
}


	 
	 

