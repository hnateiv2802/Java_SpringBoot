package com.anhtv.identity_service.service;

import com.anhtv.identity_service.dto.request.UserCreationRequest;
import com.anhtv.identity_service.dto.request.UserUpdateRequest;
import com.anhtv.identity_service.dto.response.UserResponse;
import com.anhtv.identity_service.entity.User;
import com.anhtv.identity_service.exception.AppException;
import com.anhtv.identity_service.exception.ErrorCode;
import com.anhtv.identity_service.mapper.UserMapper;
import com.anhtv.identity_service.repository.UserRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class UserService {
    UserRepository userRepository;
    UserMapper userMapper;
    // method create user
    public User createUser(UserCreationRequest request) {
        // call method existsByUsername
        if(userRepository.existsByUsername(request.getUsername())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);

        return userRepository.save(user);
    }

    // method get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // method get user
    public UserResponse getUser(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!!!")));
    }

    // method update user
    public UserResponse updateUser(String userId, UserUpdateRequest request) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found!!!"));
        userMapper.updateUser(user, request);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    // method delete user
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}