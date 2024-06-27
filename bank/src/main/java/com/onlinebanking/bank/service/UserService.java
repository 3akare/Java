package com.onlinebanking.bank.service;

import com.onlinebanking.bank.dto.*;
import jakarta.mail.MessagingException;

import javax.swing.*;

public interface UserService {
    ResponseDTO createAccount(UserDTO userDTO) throws MessagingException;
    ResponseDTO balanceEnquiry(EnquiryRequest enquiryRequest);
    String accountNameEnquiry(EnquiryRequest enquiryRequest);
    ResponseDTO creditAccount(CreditDebitDTO creditDebitDTO) throws MessagingException;
    ResponseDTO debitAccount(CreditDebitDTO creditDebitDTO) throws MessagingException;
    ResponseDTO transfer(TransferDTO transferDTO) throws MessagingException;
}
