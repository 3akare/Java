package com.onlinebanking.bank.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO {
    private String responseCode;
    private String responseMessage;
    private AccountInfo accountInfo;
}
