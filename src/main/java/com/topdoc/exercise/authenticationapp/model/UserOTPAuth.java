package com.topdoc.exercise.authenticationapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @author TAYYAB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserOTPAuth {

    @NotBlank(message = "USERNAME IS MANDATORY")
    private String username;
    @NotBlank(message = "SESSION ID IS MANDATORY")
    private String otpSessionId;
    @NotBlank(message = "OTP IS MANDATORY")
    private String otpValue;
}
