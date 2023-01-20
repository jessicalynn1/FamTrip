package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.BusinessDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.dtos.TripFormRequestDto;
import com.devmountain.famTrip.dtos.UserDto;
import com.devmountain.famTrip.entities.TripDetails;
import com.devmountain.famTrip.repositories.TripDetailsRepository;
import com.devmountain.famTrip.services.FavoritesService;
import com.devmountain.famTrip.services.TripDetailsService;
import com.devmountain.famTrip.services.TripDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.management.openmbean.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/")
public class TripDetailsController {

    @Autowired
    private TripDetailsRepository tripDetailsRepository;

    @Autowired
    private TripDetailsService tripDetails;

    @Autowired
    private FavoritesService favoritesService;

    @DeleteMapping("tripdetails/{tripDetailsId}")
    public void deleteTripById(@PathVariable Long tripDetailsId){
        tripDetails.deleteTripById(tripDetailsId);
    }

    @GetMapping("tripdetails/{tripDetailsId}")
    public List<TripDetailsDto> getAllTripsByUserId(@PathVariable Long userId) {
        return tripDetails.getAllTripsByUserId(userId);
    }

//    @GetMapping("/yelpCallList")
//    public ArrayList<BusinessDto> displayResponse(ArrayList<BusinessDto> response) {
//
//        ArrayList<BusinessDto> result = new ArrayList<>();
//
//        for (BusinessDto businessDto : response) {
////            var strBusinessDto = businessDto.toString();
//            result.add(businessDto);
//            System.out.println(businessDto);
//        }
//        return result;
//    }



    @PostMapping("tripdetails/yelpcall")
    public List<BusinessDto> yelpCall(@RequestBody TripFormRequestDto tripFormRequest) {
        Boolean restaurant = false;
        Boolean activities = false;
        String tripName = tripFormRequest.getTripName();
        String city = tripFormRequest.getCity();
        Boolean children = tripFormRequest.getChildren();
        String type = tripFormRequest.getType();

        System.out.println(tripName);
        System.out.println(city);
        System.out.println(children);
        System.out.println(type);

        if (type.equals("restaurant")) {
            restaurant = true;
        } else {
            activities = true;
        }

        TripDetailsDto tripDetailsDto = new TripDetailsDto(null, tripName, city, activities, restaurant, null, children);
        TripDetails tripDetails1 = new TripDetails(tripDetailsDto);
        tripDetailsRepository.saveAndFlush(tripDetails1);
        return favoritesService.yelpBusinessLookup(tripDetailsDto);
//        return new ArrayList<>();
    }
}
