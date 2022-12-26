package com.devmountain.famTrip.services;


import jakarta.servlet.http.HttpServletResponse;
import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.ArrayList;

public class FavoritesServiceImpl {

    //all the logic is done here
    //controller calls service
    /*
    Need to add logic here to do the following:
    Call the Yelp API

    Display results of API call

    Allow user ability to tag certain restaurants and activities as favorites

    Allow user to find past lists of favorites

    Allow user to delete favorites list

     */

//make a new method to lookup options from Yelp code below is in that class

    public ArrayList yelpBusinessLookup (/* add parameters like city later */) {
        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("accessToken", "-InuUN7JRE7hKXeCtab8nbaNDnM3Vgt2M5Hp10MRzc0t_1wDqWUHuon-hi_8W9tujveH6THcDeYQ3if1p_jFgvrrx6lfFnP0n_DLSjT6traZdDVZf1ZA0mlFRCKeY3Yx")
                .build();

        Request request = new Request.Builder()
                .url("https://yelpapiserg-osipchukv1.p.rapidapi.com/getBusinesses")
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("X-RapidAPI-Key", "a575b2fad6msh499a40142671db3p100049jsnce9262c4cb85")
                .addHeader("X-RapidAPI-Host", "YelpAPIserg-osipchukV1.p.rapidapi.com")
                .build();

        //to add a header to pass through the API key and the rapidAPI key

        Response response;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
        }
    }
}


/* Not sure if this works below... */
//    @GetMapping("/http-servlet-response")
//    public String usingHttpServletResponse (HttpServletResponse response){
//        response.addHeader("Baeldung-Example-Header", "Value-HttpServletResponse");
//        return "Response with header using HttpServletResponse";
//    }