package com.devmountain.famTrip.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestSpringBootController {

        @RequestMapping("/hello")
        public String hello() {
                return "Hello world";
        }

//        OkHttpClient client = new OkHttpClient();
//
//        RequestBody body = new FormBody.Builder()
//                .add("text", "<REQUIRED>")
//                .add("accessToken", "<REQUIRED>")
//                .build();
//
//        Request request = new Request.Builder()
//                .url("https://yelpapiserg-osipchukv1.p.rapidapi.com/getAutocomplete")
//                .post(body)
//                .addHeader("content-type", "application/x-www-form-urlencoded")
//                .addHeader("X-RapidAPI-Key", "-InuUN7JRE7hKXeCtab8nbaNDnM3Vgt2M5Hp10MRzc0t_1wDqWUHuon-hi_8W9tujveH6THcDeYQ3if1p_jFgvrrx6lfFnP0n_DLSjT6traZdDVZf1ZA0mlFRCKeY3Yx")
//                .addHeader("X-RapidAPI-Host", "YelpAPIserg-osipchukV1.p.rapidapi.com")
//                .build();
//
//        Response response = client.newCall(request).execute();


}
