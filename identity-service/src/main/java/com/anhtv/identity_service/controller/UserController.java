package com.anhtv.identity_service.controller;

import com.anhtv.identity_service.dto.request.ApiResponse;
import com.anhtv.identity_service.dto.request.UserCreationRequest;
import com.anhtv.identity_service.dto.request.UserUpdateRequest;
import com.anhtv.identity_service.dto.response.UserResponse;
import com.anhtv.identity_service.entity.User;
import com.anhtv.identity_service.service.UserService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class UserController {
    UserService userService;

    // create user
    @PostMapping
    ApiResponse<User> createUser(@RequestBody @Valid UserCreationRequest request) {
        ApiResponse<User> response = new ApiResponse<>();
//        response.setMessage("Successfully created user!");
        response.setResult(userService.createUser(request));
        return response;
    }

    // get all user
    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    // get user
    @GetMapping("/{userId}")
    public UserResponse getUserById(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    // update user
    @PutMapping("/{userId}")
    public UserResponse updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    // delete user
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted!!!";
    }

}
