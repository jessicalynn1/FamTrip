package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.BusinessDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.dtos.TripFormRequestDto;
import com.devmountain.famTrip.entities.TripDetails;
import com.devmountain.famTrip.repositories.TripDetailsRepository;
import com.devmountain.famTrip.services.FavoritesService;
import com.devmountain.famTrip.services.TripDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/")
public class TripDetailsController {

    @Autowired
    private TripDetailsRepository tripDetailsRepository;

    @Autowired
    private TripDetailsService tripDetailsService;

    @Autowired
    private FavoritesService favoritesService;

    @DeleteMapping("tripdetails/{tripDetailsId}")
    public void deleteTripById(@PathVariable Long tripDetailsId){
        tripDetailsService.deleteTripById(tripDetailsId);
    }

    @GetMapping("tripdetails/{tripDetailsId}")
    public List<TripDetailsDto> getAllTripsByUserId(@PathVariable Long userId) {
        return tripDetailsService.getAllTripsByUserId(userId);
    }

    @PostMapping("tripdetails/yelpcall")
    public List<BusinessDto> yelpCall(@RequestBody TripFormRequestDto tripFormRequest) {
        Boolean restaurant = false;
        Boolean activities = false;
        String tripName = tripFormRequest.getTripName();
        String city = tripFormRequest.getCity();
        Boolean children = tripFormRequest.getChildren();
        String type = tripFormRequest.getType();
        Long userId = tripFormRequest.getUserId();

        if (type.equals("restaurant")) {
            restaurant = true;
        } else {
            activities = true;
        }

        TripDetailsDto tripDetailsDto = new TripDetailsDto(null, tripName, city, activities, restaurant, null, children);
        tripDetailsService.addTrip(tripDetailsDto, userId);
        List<BusinessDto> result = favoritesService.yelpBusinessLookup(tripDetailsDto);

        result.forEach(business -> {
            business.setTripDetailsId(tripDetailsDto.getId());
            }
        );

        return result;
    }
}
