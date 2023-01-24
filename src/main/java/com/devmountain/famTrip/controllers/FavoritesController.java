package com.devmountain.famTrip.controllers;

import com.devmountain.famTrip.dtos.BusinessDto;
import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.dtos.UserDto;
import com.devmountain.famTrip.entities.Favorites;
import com.devmountain.famTrip.repositories.FavoritesRepository;
import com.devmountain.famTrip.repositories.TripDetailsRepository;
import com.devmountain.famTrip.services.FavoritesService;
import com.devmountain.famTrip.services.FavoritesServiceImpl;
import com.devmountain.famTrip.services.TripDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

//    @GetMapping("/test")
//    public List<BusinessDto> test() {  //if you pass in a tripdetailsdto from the form then this method will show real results
//        TripDetailsDto tripDetailsDto = new TripDetailsDto(1L, "Test Trip", "Seattle", true, false, 3, true);
//        return favoritesService.yelpBusinessLookup(tripDetailsDto);
//    }

    @PostMapping("/addFavorites")
    public void addFavorites (@RequestBody ArrayList<FavoritesDto> favoritesList) {

        System.out.println("Favorites printed here: ");
        favoritesList.forEach(System.out::println);


//        String name = businessDtoList.;
//        String address = businessDtoList.getAddress();
//        String categories = businessDtoList.getCategories();
//        String website = businessDtoList.getWebsite();

//        System.out.println("Controller name: " + name);
//        System.out.println("Controller address: " + address);
//        System.out.println("Controller website: " + website);
//        System.out.println("Controller categories: " + categories);
//
//        FavoritesDto favoritesDto = new FavoritesDto(null, name, address, null, website, null);
//        Favorites favorites1 = new Favorites(favoritesDto);
//        favoritesRepository.saveAndFlush(favorites1);
    }
}
