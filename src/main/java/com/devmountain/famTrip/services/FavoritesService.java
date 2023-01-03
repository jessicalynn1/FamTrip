package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.entities.Favorites;
import com.devmountain.famTrip.entities.User;
import jakarta.transaction.Transactional;

import java.util.List;

public interface FavoritesService {

    @Transactional
    void deleteFavoritesById(Long favoritesId);

    @Transactional
    void addFavorites(FavoritesDto favoritesDto, Long userId);

    List<Favorites> getAllFavoritesByUserId(User userId);

}
