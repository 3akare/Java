package com.onlinebanking.bank.service.impl;

import com.onlinebanking.bank.dto.ResponseDTO;
import com.onlinebanking.bank.dto.UserDTO;
import jakarta.mail.MessagingException;

public interface UserService {
    ResponseDTO createAccount(UserDTO userDTO) throws MessagingException;
}
