package com.devmountain.famTrip.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDto implements Serializable {

    private String name;
    private String address;
    private String categories;
    private String website;
    private String displayPhone;
    private Long tripDetailsId;
}