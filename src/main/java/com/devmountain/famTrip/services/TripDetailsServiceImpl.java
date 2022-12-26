package com.devmountain.famTrip.services;


import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.entities.TripDetails;
import com.devmountain.famTrip.entities.User;
import com.devmountain.famTrip.repositories.FavoritesRepository;
import com.devmountain.famTrip.repositories.TripDetailsRepository;
import com.devmountain.famTrip.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TripDetailsServiceImpl {

    /*
    Need to create the form
        -- Name of trip
        -- City
        --Activity Y/N
        --Restaurant Y/N
        --Group size
        --Children Y/N

    Find trip details in database

    Find Favorites from trip details

    Delete a trip

    Need to create a session to store query information for Yelp API call

     */

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TripDetailsRepository tripDetailsRepository;

    @Autowired
    private FavoritesRepository favoritesRepository;

    @Transactional
    public void addTrip(TripDetailsDto tripDetailsDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        TripDetails tripDetails = new TripDetails(tripDetailsDto);
        userOptional.ifPresent(tripDetails::setUser);
        tripDetailsRepository.saveAndFlush(tripDetails);
    }

    @Transactional
    public void deleteTripById(Long tripDetailsId) {
        Optional<TripDetails> tripOptional = tripDetailsRepository.findById(tripDetailsId);
        tripOptional.ifPresent(tripDetails -> tripDetailsRepository.delete(tripDetails));
    }

}

