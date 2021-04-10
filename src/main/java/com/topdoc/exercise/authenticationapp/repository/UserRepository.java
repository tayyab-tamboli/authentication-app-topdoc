package com.topdoc.exercise.authenticationapp.repository;

import com.topdoc.exercise.authenticationapp.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author TAYYAB
 */
@Repository
public interface UserRepository extends CrudRepository<User, String> {
}
