package com.meetyourteam.mytbackend.user;

import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public void createUser(User user){
        try{
            userRepository.save(user);
        }
        catch (Exception error){
            throw new IllegalStateException("Could not create user: " + error);
        }
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
}
