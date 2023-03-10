package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.entities.Favorites;
import com.devmountain.famTrip.repositories.FavoritesRepository;
import com.devmountain.famTrip.services.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users/favorites")
public class FavoritesController {

    @Autowired
    private FavoritesRepository favoritesRepository;
    @Autowired
    private FavoritesService favoritesService;

    @DeleteMapping("/{favoritesId}")
    public void deleteFavoritesById (@PathVariable Long favoritesId) {
       favoritesService.deleteFavoritesById(favoritesId);
    }

    @GetMapping("/{userId}")
    public List<FavoritesDto> getAllByUserId (@PathVariable Long userId) {
       return favoritesService.getAllByUserId(userId);
    }

    @PostMapping("/addFavorites")
    public void addFavorites (@RequestBody List<FavoritesDto> favoritesList) {

        for (FavoritesDto each: favoritesList
        ) {
            String name = each.getName();
            String address = each.getAddress();
            String website = each.getWebsite();
            String displayPhone = each.getDisplayPhone();
            String categories = each.getCategories();
            Long tripDetailsId = each.getTripDetailsId();
            System.out.print(tripDetailsId);

            FavoritesDto favoritesDto = new FavoritesDto(null, name, address, displayPhone, categories, website, null, tripDetailsId);
            favoritesService.addFavorites(favoritesDto);
        }
    }
}
