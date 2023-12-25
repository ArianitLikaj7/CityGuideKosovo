package com.arianit.CityGuideKosovo.controller;

import com.arianit.CityGuideKosovo.dto.UserDto;
import com.arianit.CityGuideKosovo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable long userId) {
        UserDto user = userService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{userId}/update-password")
    public ResponseEntity<String> updatePassword(@PathVariable long userId, @RequestParam String password) {
        userService.updatePassword(userId, password);
        return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
    }

    @PatchMapping("/{userId}/update-email")
    public ResponseEntity<String> updateEmail(@PathVariable long userId, @RequestParam String email) {
        userService.updateEmail(userId, email);
        return new ResponseEntity<>("Email updated successfully", HttpStatus.OK);
    }
}
