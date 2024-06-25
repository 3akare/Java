package com.onlinebanking.bank.service.impl;

import com.onlinebanking.bank.dto.AccountInfo;
import com.onlinebanking.bank.dto.EmailDetailsDTO;
import com.onlinebanking.bank.dto.ResponseDTO;
import com.onlinebanking.bank.dto.UserDTO;
import com.onlinebanking.bank.entity.User;
import com.onlinebanking.bank.repository.UserRepository;
import com.onlinebanking.bank.utils.AccountUtils;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;

import java.math.BigDecimal;
import java.time.Year;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @Override
    /* Creating an account - Saving a new user into Database */
    public ResponseDTO createAccount(UserDTO userDTO) throws MessagingException {
        /* check if user already exists */
        if (userRepository.existsByEmail(userDTO.getEmail())){
            return ResponseDTO.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .otherName(userDTO.getOtherName())
                .gender(userDTO.getGender())
                .address(userDTO.getAddress())
                .stateOfOrigin(userDTO.getStateOfOrigin())
                .dateOfBirth(userDTO.getDateOfBirth())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .alternativePhoneNumber(userDTO.getAlternativePhoneNumber())
                .status("ACTIVE")
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
        .build();

        User savedUser  = userRepository.save(user);
        AccountInfo accountInfo = AccountInfo.builder()
                .accountName(savedUser.getFirstName() + " " + savedUser.getLastName())
                .accountNumber(savedUser.getAccountNumber())
                .accountBalance(savedUser.getAccountBalance())
                .build();

        EmailDetailsDTO emailDetailsDTO = EmailDetailsDTO
                .builder()
                .recipient(savedUser.getEmail())
                .subject("3ank: Account Creation Success")
                .build();

        /* Create context for templating */
        Context emailContext = getEmailContext(savedUser);

        /* Send Email Alert */
        emailServiceImpl.sendEmailAlert(emailDetailsDTO, emailContext,"SuccessEmailTemplate");

        return ResponseDTO.builder()
                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS_CODE)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(accountInfo)
                .build();
    }

    private static Context getEmailContext(User savedUser) {
        Context emailContext = new Context();
        emailContext.setVariable("name", savedUser.getFirstName() + "  " + savedUser.getLastName());
        emailContext.setVariable("subject", "3ank: Account Creation Success");
        emailContext.setVariable("message", "Your 3ank account has been successfully created.");
        emailContext.setVariable("accountNumber", savedUser.getAccountNumber());
        emailContext.setVariable("balance", savedUser.getAccountBalance());
        emailContext.setVariable("year", Year.now());
        return emailContext;
    }
}
