package com.devmountain.famTrip.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestSpringBootController {

        /*
        Do I need this file? What does it do? Ask Zack
         */

        @RequestMapping("/hello")
        public String hello() {
                return "Hello world";
        }


}
