package com.devmountain.famTrip.services;


import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import okhttp3.*;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;

public class FavoritesServiceImpl {

    //all the logic is done here
    //controller calls service
    /*
    Need to add logic here to do the following:
    Call the Yelp API
    Display results of API call
    Allow user ability to tag certain restaurants and activities as favorites
    Allow user to find past lists of favorites
    Allow user to delete favorites list
     */


    public ArrayList yelpBusinessLookup (TripDetailsDto tripDetailsDto) {

        OkHttpClient client = new OkHttpClient();
        String city = tripDetailsDto.getCity();
        Boolean restaurant = tripDetailsDto.getRestaurant();
        Boolean activity = tripDetailsDto.getActivity();
        Boolean children = tripDetailsDto.getChildren();
        String restaurantTrue = "";
        String activityTrue = "";
        String categories = "";
        String price = "";

        if (restaurant) {
            restaurantTrue = "restaurants";
        } else if (activity) {
            activityTrue = "activities";
        }

        if (children && restaurant) {
            categories = "categories=pizza";
            price = "price=1&price=2";
        } else if (children && activity) {
            categories = "categories=kids_activities&categories=playgrounds&categories=recreation" +
                    "&categories=childrensmuseums&categories=planetarium&categories=indoor_playcenter&categories=trampoline";
            price = "";
        }

        String stringUrl = MessageFormat.format("https://api.yelp.com/v3/businesses/search?location={0}&term={1}{2}&" +
                "{3}&{4}&attributes=&sort_by=best_match&limit=20", city, restaurantTrue, activityTrue, categories, price);

        Request request = new Request.Builder()
                .url(stringUrl)
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer -InuUN7JRE7hKXeCtab8nbaNDnM3Vgt2M5Hp10MRzc0t_1wDqWUHuon-hi_8W9tujveH6THcDeYQ3if1p_jFgvrrx6lfFnP0n_DLSjT6traZdDVZf1ZA0mlFRCKeY3Yx")
                .build();

        Response response;
        try {
            response = client.newCall(request).execute();
            response.body().string();

            ObjectMapper objectMapper = new ObjectMapper();
            ResponseBody responseBody = client.newCall(request).execute().body();
            SimpleEntity entity = objectMapper.readValue(responseBody.string(), SimpleEntity.class);

//            Assert.assertNotNull(entity);
//            Assert.assertEquals(sampleResponse.getName(), entity.getName());

        } catch (IOException e) {
            return null;
        }
        return new ArrayList<>();
    }
}


//        Code below from Yelp Fusion API documentation, it's all about the categories when searching
//Categories to use for activities: kids_activities, playgrounds, recreation, childrensmuseums, planetarium, indoor_playcenter
//Categories to use for Events: kids-family, festivals-fairs
//Restaurant json doesn't include kids menu but MAYBE I can filter by number of $$$ (less is best) and if they take reservations
//transactions: restaurant_reservation and price: $$ or pizza

