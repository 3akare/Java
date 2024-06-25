package com.onlinebanking.bank.controller;

import com.onlinebanking.bank.dto.ResponseDTO;
import com.onlinebanking.bank.dto.UserDTO;
import com.onlinebanking.bank.service.impl.UserServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/createAccount")
    public ResponseDTO createAccount(@RequestBody  UserDTO userDTO) throws MessagingException {
        return userServiceImpl.createAccount(userDTO);
    }
}
