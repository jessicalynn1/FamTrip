package com.devmountain.famTrip.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TripFormRequestDto implements Serializable {
    String tripName;
    String city;
    Boolean children;
    String type;
    Long userId;
}
