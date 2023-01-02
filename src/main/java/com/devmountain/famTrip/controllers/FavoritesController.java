package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoritesController {

    //where you put your methods with routes
    // where you would put the method for looking at all of your favorites
    //requests come in from controllers

//    @Autowired
//    private FavoritesService favoritesService;
//
//    @DeleteMapping("/{favoritesId}")
//    public void deleteFavoritesById (@PathVariable Long favoritesId) {
//        favoritesService.deleteFavoritesById(favoritesId);
//    }
//
//    @GetMapping("/user/{favoritesId}")
//    public List<FavoritesDto> getAllFavoritesByUserId (@PathVariable Long favoritesId) {
//       return favoritesService.getAllFavoritesByUserId(favoritesId);
//    }
//
}
