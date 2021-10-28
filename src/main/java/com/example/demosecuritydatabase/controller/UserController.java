package com.example.demosecuritydatabase.controller;

import com.example.demosecuritydatabase.entity.User;
import com.example.demosecuritydatabase.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    final private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initRolesAndUser(){
        userService.initRoleAndUser();
    }

    @PostMapping("/createNewUser")
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }

    @GetMapping("/forUser")
    public String forUser(){
        return "This URL is only accessible to the user";
    }
}
