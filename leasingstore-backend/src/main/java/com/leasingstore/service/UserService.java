package com.leasingstore.service;

import com.leasingstore.dto.UserDTO;
import com.leasingstore.entity.User;
import com.leasingstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for Customer Module (B2C) - Service Discovery & Booking
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setMobile(userDTO.getMobile());
        user.setName(userDTO.getName());
        // Password handling omitted for brevity
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setEmail(userDTO.getEmail());
            user.setMobile(userDTO.getMobile());
            user.setName(userDTO.getName());
            // Password handling omitted for brevity
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
