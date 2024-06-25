package com.onlinebanking.bank.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfo {
    private String accountName;
    private String accountNumber;
    private BigDecimal accountBalance;
}


