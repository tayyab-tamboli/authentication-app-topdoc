package com.topdoc.exercise.authenticationapp.services;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.User;

/**
 * @author TAYYAB
 */
public interface IUserAppService {

    public User register(User user) throws UserException;

    public User findUserByUsername(String username) throws UserException;
}
