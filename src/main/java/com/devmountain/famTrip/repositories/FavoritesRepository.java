package com.devmountain.famTrip.repositories;

import com.devmountain.famTrip.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {


    List<Favorites> getAllByTripDetailsId(Long tripDetailsId);

    Favorites getByTripDetailsId(Long tripDetailsId);

//    public void deleteFavoritesById(Long favoritesId);
//
//    public void addFavorites(FavoritesDto favoritesDto, Long userId);

}
