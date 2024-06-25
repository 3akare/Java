package com.onlinebanking.bank.dto;

import lombok.*;

@Data
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private String firstName;
    private String lastName;
    private String otherName;
    private String gender;
    private String address;
    private String stateOfOrigin;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
}
