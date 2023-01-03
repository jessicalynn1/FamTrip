package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.dtos.UserDto;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface TripDetails {

    List<TripDetailsDto> getAllNotesByUserId(Long userId);

    @Transactional
    List<TripDetails> addTrip(TripDetailsDto tripDetailsDto, Long userId);

    @Transactional
    void deleteTripById(Long tripDetailsId);

    Optional<TripDetailsDto> getTripDetailsById(Long tripDetailsId);

    Optional<UserDto> getAllTripsByUserId(Long userId);

}
