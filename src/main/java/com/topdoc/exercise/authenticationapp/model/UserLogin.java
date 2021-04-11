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
public class UserLogin {

    @NotBlank(message = "USERNAME IS MANDATORY")
    private String username;
    @NotBlank(message = "PASSWORD IS MANDATORY")
    private String password;

}
