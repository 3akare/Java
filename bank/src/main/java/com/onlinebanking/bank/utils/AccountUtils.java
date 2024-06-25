package com.onlinebanking.bank.utils;

import java.time.Year;
import java.util.Random;

public class AccountUtils {
    public static final String ACCOUNT_ALREADY_EXISTS_CODE = "001";
    public static final String ACCOUNT_ALREADY_EXISTS_MESSAGE = "This user already exists";
    public static final String ACCOUNT_CREATION_SUCCESS_CODE = "002";
    public static final String ACCOUNT_CREATION_MESSAGE = "Account successfully created!";
    public static final String ACCOUNT_DOES_NOT_EXISTS_CODE = "003";
    public static final String ACCOUNT_DOES_NOT_EXISTS_MESSAGE = "This account does not exist";
    public static final String ACCOUNT_EXISTS_CODE = "004";
    public static final String ACCOUNT_EXISTS_MESSAGE = "User found";

    public static String generateAccountNumber(){
        /* [current year]+[0-6]*6 */
        Year currentYear = Year.now();

        /* Generate random number */
        Random random = new Random();
        int origin = 100000;
        int bound = 999999;
        int randomNumber = random.nextInt(origin,bound);

        /* Convert Year, and random number to String */
        String accountNumber = currentYear + "";
        accountNumber += randomNumber + "";
        return accountNumber;
    }
}
