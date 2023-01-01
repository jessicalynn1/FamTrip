package com.devmountain.famTrip.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDto implements Serializable {

    //make a java class that only takes out what i want from json response
    //make a new business object for each item returned
    //look at favorites as example but add more detail
    //include categories listed

    private Long id;
    private String name;
    private String address;
    private String description; //restaurant or activity
    private String categories;
    private String website;

    /*
    Ask Zack about how to create this dto
     */

//    public BusinessDto (/* takes in json response*/) {
//        if (response.getId() != null) {
//            this.id = response.getId();
//        } if (response.getName() != null) {
//            this.name = response.getId();
//        } if (response.getAddress() != null) {
//            this.address = response.getId();
//        } if (response.getDescription() != null) {
//            this.description = response.getId();
//        } if (response.getCategories() != null) {
//            this.categories = response.getId();
//        } if (response.getWebsite() != null) {
//            this.website = response.getId();
//        }
//    }

}
