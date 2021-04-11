package com.topdoc.exercise.authenticationapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;

/**
 * @author TAYYAB
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticatedUser {

    private String username;
    private String name;
    private String token;
    private Calendar expiryTime;
}
