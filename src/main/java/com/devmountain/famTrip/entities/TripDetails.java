package com.devmountain.famTrip.entities;

import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "TripDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String tripName;

    @Column
    private String city;

    @Column
    private Boolean activity;

    @Column
    private Boolean restaurant;

    @Column
    private Integer groupSize;

    @Column
    private Boolean children;


    @OneToMany(mappedBy = "tripDetails", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<Favorites> favoritesSet = new HashSet();

    @ManyToOne
    @JsonBackReference
    private User user;

    public TripDetails (TripDetailsDto tripDetailsDto) {
        if (tripDetailsDto.getTripName() != null) {
            this.tripName = tripDetailsDto.getTripName();
        }
        if (tripDetailsDto.getCity() != null) {
            this.city = tripDetailsDto.getCity();
        }
        if (tripDetailsDto.getActivity() != null) {
            this.activity = tripDetailsDto.getActivity();
        }
        if (tripDetailsDto.getRestaurant() != null) {
            this.restaurant = tripDetailsDto.getRestaurant();
        }
        if (tripDetailsDto.getGroupSize() != null) {
            this.groupSize = tripDetailsDto.getGroupSize();
        }
        if (tripDetailsDto.getChildren() != null) {
            this.children = tripDetailsDto.getChildren();
        }
    }
}
