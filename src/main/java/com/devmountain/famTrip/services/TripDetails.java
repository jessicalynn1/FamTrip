package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.TripDetailsDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface TripDetails {

    @Transactional
    void addTrip(TripDetailsDto tripDetailsDto, Long userId);

    @Transactional
    void deleteTripById(Long tripDetailsId);

    Optional<TripDetailsDto> getTripDetailsById(Long tripDetailsId);

    List<TripDetailsDto> getAllTripsByUserId(Long userId);

}
