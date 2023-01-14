package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.BusinessDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.dtos.UserDto;
import com.devmountain.famTrip.services.TripDetails;
import com.devmountain.famTrip.services.TripDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.openmbean.ArrayType;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/v1/users/tripdetails")
public class TripDetailsController {

    //add a route to get a list of options from yelp api

//    @GetMapping
//    ArrayList<String> getResult(ArrayList<String> result) {
//        /*
//        This is where I would return the list of businesses from the Yelp API call
//         */
//
//    }

    @Autowired
    private TripDetails tripDetails;

    @DeleteMapping("/{tripDetailsId}")
    public void deleteTripById(@PathVariable Long tripDetailsId){
        tripDetails.deleteTripById(tripDetailsId);
    }

//    @GetMapping("/{tripDetailsId}") //want this method to return BusinessDto, not sure if that's possible
//    public List<BusinessDto> getTripDetailsById(@PathVariable Long tripDetailsId) {
//        return tripDetails.getTripDetailsbyId(tripDetailsId);
//    }
//
//    @GetMapping("/{tripDetailsId}")  //this doesn't match the tripdetails service file
//    public List<TripDetailsDto> getAllTripsByUserId(@PathVariable Long userId) {
//        return tripDetails.getAllTripsByUserId(userId);
//    }


    //need to create a (post mapping) method to takes in the response from the form


}
