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
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FavoritesServiceImpl implements FavoritesService {

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
//            System.out.println("Business object printed here: " + business);
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

//    @Override
    @Transactional
    public List<FavoritesDto> getAllByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<TripDetails> tripDetailsList = tripDetailsRepository.findAllTripsByUserId(userOptional.get().getId());
            List<Favorites> favorites = new ArrayList<>();

            for (TripDetails trip : tripDetailsList) {
                favorites.addAll(favoritesRepository.getAllByTripDetailsId(trip.getId()));
            }

            return favorites.stream().map(favorite -> new FavoritesDto(favorite)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }
//this route isnt working because there is no userid in favorites; need to search by favoritesId
    //main issue is passing through the tripdetailsdto or id to display favorites by group on html side

    @Transactional
    public void deleteFavoritesById(Long favoritesId) {
        Optional<Favorites> favoritesOptional = favoritesRepository.findById(favoritesId);
        favoritesOptional.ifPresent(favorites -> favoritesRepository.delete(favorites));
    }

    @Transactional
    public void addFavorites(FavoritesDto favoritesDto) {
        Optional<TripDetails> temp = tripDetailsRepository.findTripDetailsById(favoritesDto.getTripDetailsId());
        favoritesDto.setTripDetailsDto(new TripDetailsDto(temp.get()));
        Favorites favorites = new Favorites(favoritesDto);
        temp.ifPresent(favorites::setTripDetails);
        System.out.println("Temp is present. Trip details Id: " + favoritesDto.getTripDetailsId());
        System.out.println(favoritesDto.getTripDetailsDto().getTripName());

        favoritesRepository.saveAndFlush(favorites);
    }
}



