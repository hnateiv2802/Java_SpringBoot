package com.anhtv.identity_service.controller;

import com.anhtv.identity_service.dto.request.UserCreationRequest;
import com.anhtv.identity_service.dto.request.UserUpdateRequest;
import com.anhtv.identity_service.entity.User;
import com.anhtv.identity_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    // create user
    @PostMapping
    public User createUser(@RequestBody @Valid UserCreationRequest request) {
        return userService.createUser(request);
    }

    // get all user
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get user
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable("userId") String userId) {
        return userService.getUser(userId);
    }

    // update user
    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UserUpdateRequest request) {
        return userService.updateUser(userId, request);
    }

    // delete user
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return "User has been deleted!!!";
    }

}
