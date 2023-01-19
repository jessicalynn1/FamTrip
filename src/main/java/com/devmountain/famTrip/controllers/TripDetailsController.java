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

    @Autowired
    private TripDetails tripDetails;

    @DeleteMapping("/{tripDetailsId}")
    public void deleteTripById(@PathVariable Long tripDetailsId){
        tripDetails.deleteTripById(tripDetailsId);
    }

    @GetMapping("/{tripDetailsId}")
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


}
