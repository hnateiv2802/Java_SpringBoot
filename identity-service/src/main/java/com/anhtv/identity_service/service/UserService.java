package com.anhtv.identity_service.service;

import com.anhtv.identity_service.dto.request.UserCreationRequest;
import com.anhtv.identity_service.dto.request.UserUpdateRequest;
import com.anhtv.identity_service.entity.User;
import com.anhtv.identity_service.exception.AppException;
import com.anhtv.identity_service.exception.ErrorCode;
import com.anhtv.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // method create user
    public User createUser(UserCreationRequest request) {
        User user = new User();

        // call method existsByUsername
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());
        return userRepository.save(user);
    }

    // method get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // method get user
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!!!"));
    }

    // method update user
    public User updateUser(String userId, UserUpdateRequest request) {
        User user = getUser(userId);
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setBirthDate(request.getBirthDate());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    // method delete user
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
