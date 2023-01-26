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

    @GetMapping("/{favoritesId}")
    public List<FavoritesDto> getAllFavoritesByUserId (@PathVariable Long userId) {
       return favoritesService.getAllFavoritesByUserId(userId);
    }

    @PostMapping("/addFavorites")
    public void addFavorites (@RequestBody List<FavoritesDto> favoritesList) {

        //pass through tripdetailsDto
        //add tripdetailsid in order to display the favorites in a group

        for (FavoritesDto each: favoritesList
        ) {
            String name = each.getName();
            String address = each.getAddress();
            String website = each.getWebsite();
            String displayPhone = each.getDisplayPhone();
            String categories = each.getCategories();

            FavoritesDto favoritesDto = new FavoritesDto(null, name, address, displayPhone, categories, website, null);
            //call the method in favoritesserviceimpl here


            Favorites favorites1 = new Favorites(favoritesDto);
            favoritesRepository.saveAndFlush(favorites1);
        }
    }
}
