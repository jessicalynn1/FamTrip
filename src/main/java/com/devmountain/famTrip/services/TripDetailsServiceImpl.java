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

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TripDetailsServiceImpl implements TripDetailsService {

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
        tripDetailsDto.setId(tripDetails.getId());
    }

    @Transactional
    public void deleteTripById(Long tripDetailsId) {
        Optional<TripDetails> tripOptional = tripDetailsRepository.findById(tripDetailsId);
        tripOptional.ifPresent(tripDetails -> tripDetailsRepository.delete(tripDetails));
    }
    public List<TripDetailsDto> getAllTripsByUserId(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            List<TripDetails> tripDetailsList = tripDetailsRepository.findAllTripsByUserId(userOptional.get());
            return tripDetailsList.stream().map(tripDetails -> new TripDetailsDto(tripDetails)).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }

    public Optional<TripDetailsDto> getTripDetailsById(Long tripDetailsId) {
        Optional<TripDetails> tripDetailsOptional = tripDetailsRepository.findTripDetailsById(tripDetailsId);
        if (tripDetailsOptional.isPresent()) {
            return Optional.of(new TripDetailsDto(tripDetailsOptional.get()));
        }
        return Optional.empty();
    }

}

