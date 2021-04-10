package com.topdoc.exercise.authenticationapp.rest;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.Response;
import com.topdoc.exercise.authenticationapp.model.User;
import com.topdoc.exercise.authenticationapp.model.UserResponse;
import com.topdoc.exercise.authenticationapp.services.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String authenticateUser() {
        return "TEST API IS RUNNING..";
    }

    @PostMapping("/login")
    public String login() {
        return "TEST API IS RUNNING..";
    }

    @PostMapping("/logout")
    public String logout() {
        return "TEST API IS RUNNING..";
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
