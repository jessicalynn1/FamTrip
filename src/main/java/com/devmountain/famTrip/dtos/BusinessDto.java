package com.devmountain.famTrip.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import javax.annotation.Generated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessDto implements Serializable {


//    private Long id;
    private String name;
    private String address;
    private String categories;
    private String website;
    private String displayPhone;
}