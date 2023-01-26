package com.devmountain.famTrip.repositories;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.devmountain.famTrip.entities.Favorites;
import com.devmountain.famTrip.entities.TripDetails;
import com.devmountain.famTrip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {

    List<Favorites> findAllByUserId(Long userId);

//    public void deleteFavoritesById(Long favoritesId);
//
//    public void addFavorites(FavoritesDto favoritesDto, Long userId);

}
