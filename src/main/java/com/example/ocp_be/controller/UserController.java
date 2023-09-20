package com.example.ocp_be.controller;

import com.example.ocp_be.entity.exceptions.ProductNotFoundException;
import com.example.ocp_be.entity.User;
import com.example.ocp_be.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public String addUser(@ModelAttribute User user) {
        User saveUser = userService.saveUser(user);
        return "homePage";
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        if (id == null) {
            throw new ProductNotFoundException("You are not allowed to ask for this user");
        }
        return ResponseEntity.ok(user);
    }
    @GetMapping("/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
        User user = userService.findUserByEmail(email);
        if (email == null) {
            throw new ProductNotFoundException("You are not allowed to ask for this user");
        }
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User successfully deleted";
    }

}
