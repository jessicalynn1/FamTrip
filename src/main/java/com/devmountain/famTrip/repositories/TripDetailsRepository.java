package com.devmountain.famTrip.repositories;

import com.devmountain.famTrip.entities.TripDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDetailsRepository extends JpaRepository<TripDetails, Long> {
}
