package com.backendforfooddelci.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.backendforfooddelci.Entity.EntityOfPlace;
import com.backendforfooddelci.Repository.SavePlaceSearchForUser;
import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.JsonArray;
import com.nimbusds.jose.shaded.gson.JsonObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceForFindTheUserPlaceByText {

    @Autowired
    private final SavePlaceSearchForUser placesTable;

    @Value("${google.api.key}")
    private String API_KEY;
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/place/textsearch/json";

    public ServiceForFindTheUserPlaceByText(SavePlaceSearchForUser placesTable) {
        this.placesTable = placesTable;
    }

    public List<EntityOfPlace> fetchGooglePlacesByName(String name) {
        List<EntityOfPlace> places = new ArrayList<>();
        
        try {
            String query = "?query=" + URLEncoder.encode(name, "UTF-8") + "&key=" + API_KEY;
            System.out.println(query);
            URL url = new URL(BASE_URL + query);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            conn.disconnect();

            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(content.toString(), JsonObject.class);
            JsonArray results = jsonResponse.getAsJsonArray("results");
            System.out.println(results);

            for (int i = 0; i < results.size(); i++) {
                JsonObject placeJson = results.get(i).getAsJsonObject();
                EntityOfPlace place = new EntityOfPlace();
                place.setCityName(placeJson.get("name").getAsString());
                JsonObject location = placeJson.getAsJsonObject("geometry").getAsJsonObject("location");
                place.setLat(location.get("lat").getAsDouble());
                place.setLng(location.get("lng").getAsDouble());
                places.add(place);
            }

            // Save the places to the repository
            placesTable.saveAll(places);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return places;
    }
}
