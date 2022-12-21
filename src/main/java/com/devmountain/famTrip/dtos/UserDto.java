package com.devmountain.famTrip.dtos;

import com.devmountain.famTrip.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<TripDetailsDto> tripDetailsDto = new HashSet<>();

    public UserDto (User user) {
        if (user.getId() != null) {
            this.id = user.getId();
        } if (user.getFirstName() != null) {
            this.firstName = user.getFirstName();
        } if (user.getLastName() != null) {
            this.lastName = user.getLastName();
        } if (user.getEmail() != null) {
            this.email = user.getEmail();
        } if (user.getPassword() != null) {
            this.password = user.getPassword();
        }
    }
}
