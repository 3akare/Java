package com.onlinebanking.bank.controller;

import com.onlinebanking.bank.dto.CreditDebitDTO;
import com.onlinebanking.bank.dto.EnquiryRequest;
import com.onlinebanking.bank.dto.ResponseDTO;
import com.onlinebanking.bank.dto.UserDTO;
import com.onlinebanking.bank.service.impl.UserServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    UserServiceImpl userServiceImpl;

    @PostMapping("/createAccount")
    public ResponseDTO createAccount(@RequestBody  UserDTO userDTO) throws MessagingException {
        return userServiceImpl.createAccount(userDTO);
    }

    @PostMapping("/creditAccount")
    public ResponseDTO creditAccount(@RequestBody CreditDebitDTO creditDebitDTO){
        return userServiceImpl.creditAccount(creditDebitDTO);
    }

    @GetMapping("/balanceEnquiry")
    public ResponseDTO balanceEnquiry(@RequestBody EnquiryRequest enquiryRequest){
        return userServiceImpl.balanceEnquiry(enquiryRequest);
    }

    @GetMapping("/accountNameEnquiry")
    public String accountNameEnquiry(@RequestBody EnquiryRequest enquiryRequest){
        return userServiceImpl.accountNameEnquiry(enquiryRequest);
    }
}
