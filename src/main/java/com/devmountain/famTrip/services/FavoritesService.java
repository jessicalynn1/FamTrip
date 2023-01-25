package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.dtos.TripDetailsDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FavoritesService {

    @Transactional
    void deleteFavoritesById(Long favoritesId);

    @Transactional
    void addFavorites(FavoritesDto favoritesDto, Long userId);

    List<FavoritesDto> getAllFavoritesByUserId(Long userId);

    public List yelpBusinessLookup (TripDetailsDto tripDetailsDto);

}
