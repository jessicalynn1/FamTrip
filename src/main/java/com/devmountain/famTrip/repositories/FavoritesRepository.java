package com.devmountain.famTrip.repositories;

import com.devmountain.famTrip.entities.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
