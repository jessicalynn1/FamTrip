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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTripName() {
//        return tripName;
//    }
//
//    public void setTripName(String tripName) {
//        this.tripName = tripName;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public Boolean getActivity() {
//        return activity;
//    }
//
//    public void setActivity(Boolean activity) {
//        this.activity = activity;
//    }
//
//    public Boolean getRestaurant() {
//        return restaurant;
//    }
//
//    public void setRestaurant(Boolean restaurant) {
//        this.restaurant = restaurant;
//    }
//
//    public Integer getGroupSize() {
//        return groupSize;
//    }
//
//    public void setGroupSize(Integer groupSize) {
//        this.groupSize = groupSize;
//    }
//
//    public Boolean getChildren() {
//        return children;
//    }
//
//    public void setChildren(Boolean children) {
//        this.children = children;
//    }

//    public TripDetails(Long id, String tripName, String city, Boolean activity, Boolean restaurant, Integer groupSize, Boolean children) {
//        this.id = id;
//        this.tripName = tripName;
//        this.city = city;
//        this.activity = activity;
//        this.restaurant = restaurant;
//        this.groupSize = groupSize;
//        this.children = children;
//    }

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
