package com.devmountain.famTrip.dtos;

import com.devmountain.famTrip.entities.Favorites;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavoritesDto implements Serializable {
    private Long id;
    private String name;
    private String address;
    private String type;
    private String website;
    private TripDetailsDto tripDetailsDto;

    public FavoritesDto (Favorites favorites) {
        if (favorites.getId() != null) {
            this.id = favorites.getId();
        } if (favorites.getName() != null) {
            this.name = favorites.getName();
        } if (favorites.getAddress() != null) {
            this.address = favorites.getAddress();
        } if (favorites.getType() != null) {
            this.type = favorites.getType();
        } if (favorites.getWebsite() != null) {
            this.website = favorites.getWebsite();
        } if (favorites.getTripDetails() != null) {
            tripDetailsDto = new TripDetailsDto(favorites.getTripDetails());
        }
    }
}
