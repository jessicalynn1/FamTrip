package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.entities.Favorites;
import com.devmountain.famTrip.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface FavoritesService {

    @Transactional
    void deleteFavoritesById(Long favoritesId);

    @Transactional
    void addFavorites(FavoritesDto favoritesDto, Long userId);

    List<FavoritesDto> getAllFavoritesByUserId(Long userId);

    public ArrayList yelpBusinessLookup (TripDetailsDto tripDetailsDto);

}
