package com.meetyourteam.mytbackend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@SuppressWarnings("unused")
public class UserController {

    public final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        userService.createUser(user);
        return user;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
