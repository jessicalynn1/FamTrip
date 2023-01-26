package com.devmountain.famTrip.repositories;

import com.devmountain.famTrip.entities.TripDetails;
import com.devmountain.famTrip.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TripDetailsRepository extends JpaRepository<TripDetails, Long> {

    List<TripDetails> findAllTripsByUserId(Long userId);

    Optional<TripDetails> findTripDetailsById(Long tripDetailsId);

}
