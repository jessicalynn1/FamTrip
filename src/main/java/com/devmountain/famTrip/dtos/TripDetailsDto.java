package com.devmountain.famTrip.dtos;

import com.devmountain.famTrip.entities.TripDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDetailsDto implements Serializable {
    private Long id;
    private String tripName;
    private String city;
    private Boolean activity;
    private Boolean restaurant;
    private Integer groupSize;
    private Boolean children;

    public TripDetailsDto(TripDetails tripDetails) {
        if (tripDetails.getId() != null) {
            this.id = tripDetails.getId();
        }
        if (tripDetails.getTripName() != null) {
            this.tripName = tripDetails.getTripName();
        }
        if (tripDetails.getCity() != null) {
            this.city = tripDetails.getCity();
        }
        if (tripDetails.getActivity() != null) {
            this.activity = tripDetails.getActivity();
        }
        if (tripDetails.getRestaurant() != null) {
            this.restaurant = tripDetails.getRestaurant();
        }
        if (tripDetails.getGroupSize() != null) {
            this.groupSize = tripDetails.getGroupSize();
        }
        if (tripDetails.getChildren() != null) {
            this.children = tripDetails.getChildren();
        }
    }
}
