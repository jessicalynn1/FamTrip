package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.BusinessDto;
import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.services.FavoritesService;
import com.devmountain.famTrip.services.FavoritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesService favoritesService;

    @DeleteMapping("/{favoritesId}")
    public void deleteFavoritesById (@PathVariable Long favoritesId) {
       favoritesService.deleteFavoritesById(favoritesId);
    }

    @GetMapping("/{favoritesId}")
    public List<FavoritesDto> getAllFavoritesByUserId (@PathVariable Long userId) {
       return favoritesService.getAllFavoritesByUserId(userId);
    }

//    @GetMapping("/test")
//    public List<BusinessDto> test() {  //if you pass in a tripdetailsdto from the form then this method will show real results
//        TripDetailsDto tripDetailsDto = new TripDetailsDto(1L, "Test Trip", "Seattle", true, false, 3, true);
//        return favoritesService.yelpBusinessLookup(tripDetailsDto);
//    }

}
