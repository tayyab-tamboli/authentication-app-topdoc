package com.topdoc.exercise.authenticationapp.services;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.AuthenticatedUser;
import com.topdoc.exercise.authenticationapp.model.User;
import com.topdoc.exercise.authenticationapp.model.UserLogin;
import com.topdoc.exercise.authenticationapp.model.UserOTPAuth;

/**
 * @author TAYYAB
 */
public interface IUserAppService {

    User register(User user) throws UserException;

    User findUserByUsername(String username) throws UserException;

    AuthenticatedUser login(UserLogin user) throws UserException;

    User authenticateUser(UserOTPAuth otpAuth) throws UserException;

}
