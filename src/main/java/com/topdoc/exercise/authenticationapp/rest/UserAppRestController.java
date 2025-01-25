package com.topdoc.exercise.authenticationapp.rest;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.*;
import com.topdoc.exercise.authenticationapp.services.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

/**
 * @author TAYYAB
 */

@ControllerAdvice
@RestController
@RequestMapping("/api/v1/user")
public class UserAppRestController {

    @Autowired
    IUserAppService userAppService;

    @PostMapping("/register")
    public UserResponse registerUser(@Valid @RequestBody User user) throws Exception {
        User registeredUser = userAppService.register(user);
        return getResponseObject(registeredUser, "USER CREATED");
    }

    @PostMapping("/authenticate")
    public UserResponse authenticateUser(@Valid @RequestBody UserOTPAuth otpAuth) throws UserException {
        User authenticateUser = userAppService.authenticateUser(otpAuth);
        return getResponseObject(authenticateUser, "USER AUTHENTICATED");
    }

    @PostMapping("/login")
    public AuthenticatedUser login(@Valid @RequestBody UserLogin userLogin) throws UserException {
        return userAppService.login(userLogin);
    }

    @PostMapping("/logout")
    public String logout() {
        return "LOGGED OUT";
    }

    @GetMapping("/profile/{username}")
    public UserResponse getProfileByUsername(@PathVariable(value = "username", required = true) String username) throws UserException {
        User user = userAppService.findUserByUsername(username);
        return getResponseObject(user, "USER FOUND");
    }

    private UserResponse getResponseObject(User user, String message) {
        UserResponse userResponse = new UserResponse();
        Response response = new Response(200, "SUCCESS", message);
        userResponse.setUser(user);
        userResponse.setResponse(response);
        return userResponse;
    }
}
