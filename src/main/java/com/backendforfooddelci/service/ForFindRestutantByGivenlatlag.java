package com.backendforfooddelci.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import com.backendforfooddelci.Entity.Restaurant;
import com.backendforfooddelci.Repository.MenuForRestaurantRepository;
import com.backendforfooddelci.Repository.RestroRepository;
// Make sure this is the correct package
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ForFindRestutantByGivenlatlag {

    @Autowired
    private RestroRepository repo;
    
    @Autowired
	private MenuForRestaurantRepository menuRepo;
    
    @Value("${opencage.api.key}")
    private String apiKey; // Better to use environment variables
    private static final OkHttpClient client = new OkHttpClient();

    public List<Restaurant> findRestaurantsByLatitudeAndLongitudeTopTrending(double lat, double lon) {
        String url = "https://api.opencagedata.com/geocode/v1/json?q=" + lat + "+" + lon + "&key=" + apiKey;

        List<Restaurant> result = new ArrayList<>();
        double populationDensity = 0;

        try {
            Request request = new Request.Builder().url(url).build();
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    String responseBody = response.body().string();
                    JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();

                    // Example parsing; adjust based on the actual API response structure
                    if (jsonObject.has("results")) {
                        JsonObject firstResult = jsonObject.getAsJsonArray("results").get(0).getAsJsonObject();
                        JsonObject components = firstResult.getAsJsonObject("components");

                        // Adjust based on the actual API response structure
                        if (components.has("population_density")) {
                            populationDensity = components.get("population_density").getAsDouble();
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error fetching data: " + e.getMessage());
        }

        // Determine the search radius based on population density
        double radius;
        if (populationDensity > 1000) {
            radius = 7;
        } else if (populationDensity > 500) {
            radius = 14;
        } else {
            radius = 25;
        }

        // Fetch nearby restaurants
        result = repo.findNearbyRestaurants(lon, lat, radius);

        return filterOutByReview(result);
    }
    
    public List<Restaurant> filterOutByReview(List<Restaurant> restaurants) {
        return restaurants.stream()
            .filter(restaurant -> {
                double noOfMenu = menuRepo.countMenusWithHighReviewsByRestaurantId(restaurant.getId());
                double hygieneRating = restaurant.getHygieneRating();
                double restaurantReview = restaurant.getReview();
                
                // Adjust weights as needed
                double score = calculateScore(noOfMenu, hygieneRating, restaurantReview);
                return score >= 3.5;
            })
            .collect(Collectors.toList());
    }

    private double calculateScore(double noOfMenu, double hygieneRating, double restaurantReview) {
        // Example: Weighted sum of the factors
        double noOfMenuWeight = 0.4;
        double hygieneRatingWeight = 0.3;
        double restaurantReviewWeight = 0.3;

        return (noOfMenuWeight * noOfMenu) + (hygieneRatingWeight * hygieneRating) + (restaurantReviewWeight * restaurantReview);
    }
}
