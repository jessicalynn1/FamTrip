package com.devmountain.famTrip.services;


import com.devmountain.famTrip.dtos.BusinessDto;
import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.entities.Favorites;
import com.devmountain.famTrip.entities.TripDetails;
import com.devmountain.famTrip.entities.User;
import com.devmountain.famTrip.repositories.FavoritesRepository;
import com.devmountain.famTrip.repositories.TripDetailsRepository;
import com.devmountain.famTrip.repositories.UserRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.transaction.Transactional;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.lang.model.element.Element;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

@Service
public class FavoritesServiceImpl implements FavoritesService {

    //all the logic is done here
    //controller calls service
    /*
    Need to do the following:
    Call the Yelp API
    Display results of API call
    Allow user ability to tag certain restaurants and activities as favorites
    Allow user to find past lists of favorites
    Allow user to delete favorites list

//        Code below from Yelp Fusion API documentation, it's all about the categories when searching
//Categories to use for activities: kids_activities, playgrounds, recreation, childrensmuseums, planetarium, indoor_playcenter
//Categories to use for Events: kids-family, festivals-fairs
//Restaurant json doesn't include kids menu but MAYBE I can filter by number of $$$ (less is best) and if they take reservations
//transactions: restaurant_reservation and price: $$ or pizza
     */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripDetailsRepository tripDetailsRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;

    public List<BusinessDto> yelpBusinessLookup(TripDetailsDto tripDetailsDto) {

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

        List<BusinessDto> result = null;

        try {
            response = client.newCall(request).execute();
            String responseString = response.body().string();
            System.out.println(responseString);

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(responseString);

            result = parseYelpResponse(jsonNode);

        } catch (IOException e) {
            return null;
        }
        return result;
    }

    public List<BusinessDto> parseYelpResponse(JsonNode jsonNode) {

        Iterator<JsonNode> businesses = jsonNode.get("businesses").elements();
        List<BusinessDto> result = new ArrayList<>();

        while (businesses.hasNext()) {
            JsonNode business = businesses.next();
            System.out.println("Business object printed here: " + business);
            BusinessDto businessDto = new BusinessDto();

            businessDto.setName(business.get("name").asText());
            businessDto.setWebsite(business.get("url").asText());
            businessDto.setDisplayPhone(business.get("display_phone").asText());

            JsonNode categories = business.get("categories");
            ArrayList<String> strCategories = new ArrayList<>();
            JsonNode location = business.get("location");
            JsonNode addresses = location.get("display_address");
            ArrayList<String> strAddress = new ArrayList<>();

            for (Iterator<JsonNode> it = categories.elements(); it.hasNext(); ) {
                JsonNode category = it.next();

                strCategories.add(category.get("title").asText());
            }
            businessDto.setCategories(String.join(", ", strCategories));

            for (Iterator<JsonNode> it = addresses.elements(); it.hasNext();) {
                JsonNode address = it.next();

                strAddress.add(address.asText());
            }
            businessDto.setAddress(String.join(", ", strAddress));

            result.add(businessDto);
        }
        return result;
        }


    @Override
    @Transactional
    public List<FavoritesDto> getAllFavoritesByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<TripDetails> tripDetails = tripDetailsRepository.findAllTripsByUserId(userOptional.get());
            System.out.println(tripDetails);
        }
        return Collections.emptyList();
    }


    @Transactional
    public void deleteFavoritesById(Long favoritesId) {
        Optional<Favorites> favoritesOptional = favoritesRepository.findById(favoritesId);
        favoritesOptional.ifPresent(favorites -> favoritesRepository.delete(favorites));
    }

    @Transactional
    public void addFavorites(FavoritesDto favoritesDto, Long userId) {  //wouldn't this be a businessDto?
        Optional<User> userOptional = userRepository.findById(userId);
        Favorites favorites = new Favorites(favoritesDto);
//        userOptional.ifPresent(favorites::setUser); // not sure where this error is coming from
        favoritesRepository.saveAndFlush(favorites);
    }

//    @Transactional
//    public ArrayList<BusinessDto> displayResponse(ArrayList<BusinessDto> response) {
//
//        return;         //sent question to Zack about this method
//    }

}



