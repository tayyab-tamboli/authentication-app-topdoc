package com.topdoc.exercise.authenticationapp.services.impl;

import com.topdoc.exercise.authenticationapp.exception.UserException;
import com.topdoc.exercise.authenticationapp.model.User;
import com.topdoc.exercise.authenticationapp.repository.UserRepository;
import com.topdoc.exercise.authenticationapp.services.IUserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author TAYYAB
 */
@Service
public class UserAppService implements IUserAppService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User register(User user) throws UserException {
        if (userRepository.existsById(user.getUsername())) {
            throw new UserException(400, "USER ALREADY EXIST");
        } else {
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public User findUserByUsername(String username) throws UserException {
        Optional<User> userOptional = userRepository.findById(username);
        return userOptional.orElseThrow(() -> new UserException(404, "USER NOT FOUND"));
    }
}
