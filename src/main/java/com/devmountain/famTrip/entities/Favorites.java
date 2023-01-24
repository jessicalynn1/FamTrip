package com.devmountain.famTrip.entities;

import com.devmountain.famTrip.dtos.FavoritesDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Favorites")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String displayPhone;
    @Column
    private String website;

    @Column
    private String categories;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getDisplayPhone() {
        return displayPhone;
    }
    public void setDisplayPhone(String displayPhone) {
        this.displayPhone = displayPhone;
    }

    public String getWebsite() {
        return website;
    }
    public void setWebsite(String website) {
        this.website = website;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public Favorites(Long id, String name, String address, String displayPhone, String website) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.displayPhone = displayPhone;
        this.website = website;
        this.categories = categories;
    }

    @ManyToOne
    @JsonBackReference
    private TripDetails tripDetails;

    public Favorites (FavoritesDto favoritesDto) {
        if (favoritesDto.getName() != null) {
            this.name = favoritesDto.getName();
        }
        if (favoritesDto.getAddress() != null) {
            this.address = favoritesDto.getAddress();
        }
        if (favoritesDto.getDisplayPhone() != null) {
            this.displayPhone = favoritesDto.getDisplayPhone();
        }
        if (favoritesDto.getWebsite() != null) {
            this.website = favoritesDto.getWebsite();
        }
        if (favoritesDto.getCategories() != null) {
            this.categories = favoritesDto.getCategories();
        }
    }
}
