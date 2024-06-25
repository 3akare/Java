package com.onlinebanking.bank.service.impl;

import com.onlinebanking.bank.dto.CreditDebitDTO;
import com.onlinebanking.bank.dto.EnquiryRequest;
import com.onlinebanking.bank.dto.ResponseDTO;
import com.onlinebanking.bank.dto.UserDTO;
import jakarta.mail.MessagingException;

public interface UserService {
    ResponseDTO createAccount(UserDTO userDTO) throws MessagingException;
    ResponseDTO balanceEnquiry(EnquiryRequest enquiryRequest);
    String accountNameEnquiry(EnquiryRequest enquiryRequest);
    ResponseDTO creditAccount(CreditDebitDTO creditDebitDTO);
    ResponseDTO debitAccount(CreditDebitDTO creditDebitDTO);
}
