package com.topdoc.exercise.authenticationapp.services.impl;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.*;
import com.topdoc.exercise.authenticationapp.repository.UserRepository;
import com.topdoc.exercise.authenticationapp.services.IUserAppService;
import com.topdoc.exercise.authenticationapp.services.UserAppOTPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author TAYYAB
 */
@Service
public class UserAppService implements IUserAppService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAppOTPService otpService;

    public static Map<String, AuthenticatedUser> authUsers = new HashMap<>();

    @Override
    public User register(User user) throws UserException {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserException(400, "USER ALREADY EXIST");
        } else {
            user.setActive(false);
            OTPResponse otpResponse = otpService.generateOTP(user.getMobile());
            user.setOtpSessionId(otpResponse.getDetails());
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User findUserByUsername(String username) throws UserException {
        Optional<User> userOptional = userRepository.findById(username);
        return userOptional.orElseThrow(() -> new UserException(404, "USER NOT FOUND"));
    }

    @Override
    public AuthenticatedUser login(UserLogin userLogin) throws UserException {
        Calendar now = Calendar.getInstance();
        String username = userLogin.getUsername();
        Optional<User> userOptional = userRepository.findByUsernameAndPasswordAndActive(username, userLogin.getPassword(), true);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            String uuid = UUID.randomUUID().toString();
            AuthenticatedUser authenticatedUser = new AuthenticatedUser();
            authenticatedUser.setUsername(user.getUsername());
            authenticatedUser.setName(user.getName());
            authenticatedUser.setToken(uuid);
            now.add(Calendar.SECOND, 120);
            authenticatedUser.setExpiryTime(now);
            authUsers.put(uuid, authenticatedUser);
            return authenticatedUser;
        } else {
            throw new UserException(400, "INVALID USERNAME OR PASSWORD");
        }
    }

    @Override
    public User authenticateUser(UserOTPAuth otpAuth) throws UserException {
        User user = findUserByUsername(otpAuth.getUsername());
        boolean isAuthenticateSuccessfully = otpService.authenticateOTP(otpAuth);
        if (isAuthenticateSuccessfully) {
            user.setActive(true);
            userRepository.save(user);
        }
        return user;
    }
}
