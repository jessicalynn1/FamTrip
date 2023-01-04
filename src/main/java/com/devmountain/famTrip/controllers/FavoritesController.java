package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.services.FavoritesService;
import com.devmountain.famTrip.services.FavoritesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users/favorites") //Not sure where this is supposed to map to
public class FavoritesController {

    //where you put your methods with routes
    // where you would put the method for looking at all of your favorites
    //requests come in from controllers
    //this is where you call the yelpapi method

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

    @GetMapping("/test")
    public void test() {
        TripDetailsDto tripDetailsDto = new TripDetailsDto(1L, "Test Trip", "Seattle", true, false, 3, true);
        favoritesService.yelpBusinessLookup(tripDetailsDto);

    }

}
