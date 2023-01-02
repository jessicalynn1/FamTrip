package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.FavoritesDto;
import jakarta.transaction.Transactional;

import java.util.List;

public interface FavoritesService {

    @Transactional
    void deleteFavoritesById(Long favoritesId);

    @Transactional
    void addFavorites(FavoritesDto favoritesDto, Long userId);

    @Transactional
    List<FavoritesDto> getAllFavoritesByUserId(Long favoritesId);

}
