package com.devmountain.famTrip.services;

import com.devmountain.famTrip.dtos.UserDto;
import com.devmountain.famTrip.entities.User;
import com.devmountain.famTrip.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public List<String> addUser(UserDto userDto) {
        List<String> response = new ArrayList<>();
        User user = new User(userDto);
        userRepository.saveAndFlush(user);
        String strResponse = "http://localhost:8080/login.html";
        response.add(strResponse);
        response.add("You have successfully added a new user.");
        return response;
    }

    @Override
    public List<String> userLogin(UserDto userDto) {
        List<String> response = new ArrayList<>();
        Optional<User> userOptional = userRepository.findByUserName(userDto.getUserName());

        if (userOptional.isPresent()) {
            if (passwordEncoder.matches(userDto.getPassword(), userOptional.get().getPassword())) {
                String strResponse = "http://localhost:8080/home.html";
                response.add(strResponse);
                response.add(String.valueOf(userOptional.get().getId()));
                response.add("You have successfully logged in.");
            } else {
                response.add("You have entered an incorrect login and password combination.");
            }
        } else {
            response.add("You have entered an incorrect login and password combination.");
        }
        return response;
    }
}

