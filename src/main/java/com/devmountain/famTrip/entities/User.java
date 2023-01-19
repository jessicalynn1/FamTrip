package com.devmountain.famTrip.entities;

import com.devmountain.famTrip.dtos.TripDetailsDto;
import com.devmountain.famTrip.dtos.UserDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

//    @Column
//    private String lastName;

//    @Column(unique = true)
//    private String email;

    @Column
    private String password;

    public Long getId() {
        return id;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonManagedReference
    private Set<TripDetails> tripDetailsSet = new HashSet();

    public User(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
//        this.lastName = lastName;
//        this.email = email;
        this.password = password;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = userName;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public User (UserDto userDto) {
        if (userDto.getUserName() != null) {
            this.userName = userDto.getUserName();
//        } if (userDto.getLastName() != null) {
//            this.lastName = userDto.getLastName();
//        } if (userDto.getEmail() != null) {
//            this.email = userDto.getEmail();
        } if (userDto.getPassword() != null) {
            this.password = userDto.getPassword();
        }
    }

}
