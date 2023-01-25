package com.devmountain.famTrip.services;

import java.util.List;

public class YelpResponse {

    List<YelpBusiness> businesses;
    public void print() {
        for (YelpBusiness yelpBusiness : businesses ) {
            System.out.println(yelpBusiness.toString());
        }
    }

}
